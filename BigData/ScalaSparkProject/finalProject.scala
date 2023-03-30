/*
        Select a categorical variable and a numeric variable and form the key-value pair and
        create a pairRDD called `population`.
*/

val csv = sc.textFile("input/OECDGas.csv")
val rowsWithHeader = csv.map(line => line.split(",").map(_.trim)).map(row => (row(1), row(3)))
val header = rowsWithHeader.first
val population = rowsWithHeader.filter(_._1 != header._1).map(row => (row._1.replaceAll("\"", ""), row._2.toDouble))
val populationGrouped = population.groupByKey()

/*
        Compute the mean mpg and variance for each category
*/

def mean(i: Iterable[Double]) = i.sum.toDouble/i.count(_=>true)

def variance(i: Iterable[Double]) = { 
  val m = mean(i)
  val b = i.map(x => math.pow(x - m, 2))
  b.sum / i.count(_=>true)
}

val populationMeanVariance = populationGrouped.map(x => (x._1, (mean(x._2), variance(x._2))))

/*
        Create the sample for bootstrapping (25% of the population without replacement)
*/
val sample = population.sample(false, 0.25)

/*
        Do 1000 times
*/
var arrSample: Array[(String, (Double, Double))] = Array.empty[(String, (Double, Double))]

// Loop to resample and compute mean and variance
for (i <- 1 to 1000) {
  // Create a resampled dataset by sampling with replacement
  val resampledDatasets = sample.sample(true, 1)
  
  // Compute the mean and variance for each category
  val resampledDatasetsGrouped = resampledDatasets.groupByKey()
  val sampleMeanVariance = resampledDatasetsGrouped.map(x => (x._1, (mean(x._2), variance(x._2))))
  
  // Add the mean and variance values to the arrSample array
  arrSample = arrSample ++ sampleMeanVariance.collect()
}

/*
        Get the average and display the result
*/

import org.apache.spark.rdd.RDD
val rddSampleAvg: RDD[(String, (Double, Double))] = sc.parallelize(arrSample)
val rddSampleAvgReduced = rddSampleAvg.reduceByKey((a, b) => (a._1 + b._1, a._2 + b._2))
val arrSampleAvg = rddSampleAvgReduced.map(x => (x._1, (x._2._1 / 1000, x._2._2 / 1000)))

arrSampleAvg.foreach(println)


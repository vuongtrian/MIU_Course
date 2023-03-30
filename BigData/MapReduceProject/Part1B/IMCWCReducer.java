import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
public class IMCWCReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
 
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int count = 0;
        for (IntWritable i : values) {
            count += i.get();
        }
 
        context.write(key, new IntWritable(count));
    }
}
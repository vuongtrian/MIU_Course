package Assignment_Lession_7_1;

public class City implements Comparable{
    private String cityName;
    private double temperature;

    public City() {
    }

    public City(String cityName, double temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean compareTo(City theCity) {
        if(this.temperature <= theCity.getTemperature()) {
            return true;
        }
        return false;
    }
}

package miu.edu.CarRental.intergration.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "carfleet")
public class CarFleetProperties {
    private String url;
    private int maxReserve;

    public CarFleetProperties() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMaxReserve() {
        return maxReserve;
    }

    public void setMaxReserve(int maxReserve) {
        this.maxReserve = maxReserve;
    }
}

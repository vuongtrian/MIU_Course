package miu.edu;

public class Address {
    private String stress;
    private String city;
    private String zip;

    public Address() {
    }

    public Address(String stress, String city, String zip) {
        this.stress = stress;
        this.city = city;
        this.zip = zip;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "stress='" + stress + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}

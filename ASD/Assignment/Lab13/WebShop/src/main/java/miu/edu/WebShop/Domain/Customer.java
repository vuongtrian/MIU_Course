package miu.edu.WebShop.Domain;

public class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return "Customer{name='" + this.name + "', email='" + this.email + "', phone='" + this.phone + "'}";
    }
}

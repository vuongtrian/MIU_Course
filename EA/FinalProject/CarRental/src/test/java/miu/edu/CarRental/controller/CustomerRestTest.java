package miu.edu.CarRental.controller;

import io.restassured.RestAssured;
import miu.edu.CarRental.service.dto.CustomerDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class CustomerRestTest {

    private int countId = 0;

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8081);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }



    @Test
    public void testAddCustomer() {
        // add the customer
        CustomerDTO customer = new CustomerDTO("Jack", "jack@gmail.com");
        CustomerDTO result = given()
                .contentType("application/json")
                .body(customer)
                .when().post("/customers").then()
                .statusCode(201)
                .extract().body().as(CustomerDTO.class);
        // get the car and verify
        given()
                .when()
                .get("customers/"+result.getCustomerNumber())
                .then()
                .statusCode(200)
                .and()
                .body("name",equalTo("Jack"))
                .body("email",equalTo("jack@gmail.com"));
        //cleanup
        given()
                .when()
                .delete("customers/"+result.getCustomerNumber());
    }

    @Test
    public void testRemoveCustomer() {
        // add the customer
        CustomerDTO customer = new CustomerDTO("Jack", "jack@gmail.com");
        CustomerDTO result = given()
                .contentType("application/json")
                .body(customer)
                .when().post("/customers").then()
                .statusCode(201)
                .extract().body().as(CustomerDTO.class);

        given()
                .when()
                .delete("customers/"+result.getCustomerNumber());

        given()
                .when()
                .get("customers/"+result.getCustomerNumber())
                .then()
                .statusCode(404)
                .and()
                .body(equalTo("Customer with number " + result.getCustomerNumber() + " is not available"));
    }

    @Test
    public void testUpdateCustomer() {
        // add the customer
        CustomerDTO customer = new CustomerDTO("Jack", "jack@gmail.com");
        CustomerDTO updatedCustomer = new CustomerDTO("Jack", "jack@miu.com");
        CustomerDTO result = given()
                .contentType("application/json")
                .body(customer)
                .when().post("/customers").then()
                .statusCode(201)
                .extract().body().as(CustomerDTO.class);
        //update customer
        given()
                .contentType("application/json")
                .body(updatedCustomer)
                .when().put("/customers/"+result.getCustomerNumber())
                .then()
                .statusCode(200);
        // get the customer and verify
        given()
                .when()
                .get("customers/"+result.getCustomerNumber())
                .then()
                .statusCode(200)
                .and()
                .body("name",equalTo("Jack"))
                .body("email",equalTo("jack@miu.com"));
        //cleanup
        given()
                .when()
                .delete("customers/"+result.getCustomerNumber());
    }

    @Test
    public void testSearchCustomerByName() {
        // add the customer
        CustomerDTO customer1 = new CustomerDTO("Jack", "jack@gmail.com");
        CustomerDTO customer2 = new CustomerDTO("Mary", "mary@gmail.com");
        given()
                .contentType("application/json")
                .body(customer1)
                .when().post("/customers").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(customer2)
                .when().post("/customers").then()
                .statusCode(201);

        // search customer by name
        given()
                .queryParam("name", "Jack")
                .when()
                .get("/customers/search")
                .then()
                .statusCode(302)
                .and()
                .body("customers.name", hasItem("Jack"))
                .body("customers.email", hasItem("jack@gmail.com"));

        //cleanup
        given()
                .when()
                .delete("customers/4");
        given()
                .when()
                .delete("customers/5");
    }

    @Test
    public void testSearchCustomerByEmail() {
        // add the customer
        CustomerDTO customer1 = new CustomerDTO("Jack", "jack@gmail.com");
        CustomerDTO customer2 = new CustomerDTO("Mary", "mary@gmail.com");
        given()
                .contentType("application/json")
                .body(customer1)
                .when().post("/customers").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(customer2)
                .when().post("/customers").then()
                .statusCode(201);

        // search customer by email
        given()
                .queryParam("email", "jack@gmail.com")
                .when()
                .get("/customers/search")
                .then()
                .statusCode(302)
                .and()
                .body("customers.name", hasItem("Jack"))
                .body("customers.email", hasItem("jack@gmail.com"));

        //cleanup
        given()
                .when()
                .delete("customers/6");
        given()
                .when()
                .delete("customers/7");
    }

    @Test
    public void testSearchCarByNameAndEmail() {
        // add the customer
        CustomerDTO customer1 = new CustomerDTO("Jack", "jack@gmail.com");
        CustomerDTO customer2 = new CustomerDTO("Mary", "mary@gmail.com");
        given()
                .contentType("application/json")
                .body(customer1)
                .when().post("/customers").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(customer2)
                .when().post("/customers").then()
                .statusCode(201);

        // search customer by email
        given()
                .queryParam("name", "Jack")
                .queryParam("email", "jack@gmail.com")
                .when()
                .get("/customers/search")
                .then()
                .statusCode(302)
                .and()
                .body("customers.name", hasItem("Jack"))
                .body("customers.email", hasItem("jack@gmail.com"));

        //cleanup
        given()
                .when()
                .delete("customers/8");
        given()
                .when()
                .delete("customers/9");
    }
}

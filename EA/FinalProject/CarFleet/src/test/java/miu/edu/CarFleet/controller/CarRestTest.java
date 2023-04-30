package miu.edu.CarFleet.controller;

import io.restassured.RestAssured;
import miu.edu.CarFleet.service.dto.CarDTO;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class CarRestTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testAddCar() {
        // add the car
        CarDTO car = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "AVAILABLE");
        given()
                .contentType("application/json")
                .body(car)
                .when().post("/cars").then()
                .statusCode(201);
        // get the car and verify
        given()
                .when()
                .get("cars/123FFIO")
                .then()
                .statusCode(200)
                .and()
                .body("licensePlate",equalTo("123FFIO"))
                .body("type",equalTo("Camry"))
                .body("brand",equalTo("Toyota"))
                .body("price",equalTo(25.32f))
                .body("status",equalTo("AVAILABLE"));
        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
    }

    @Test
    public void testRemoveCar() {
        // add the car to be deleted car
        CarDTO car = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "AVAILABLE");
        given()
                .contentType("application/json")
                .body(car)
                .when().post("/cars").then()
                .statusCode(201);

        given()
                .when()
                .delete("cars/123FFIO");

        given()
                .when()
                .get("cars/123FFIO")
                .then()
                .statusCode(404)
                .and()
                .body(equalTo("Car with license plate 123FFIO is not available"));
    }

    @Test
    public void testUpdateCar() {
        // add the car
        CarDTO car = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "AVAILABLE");
        CarDTO updatedCar = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "RENT");
        given()
                .contentType("application/json")
                .body(car)
                .when().post("/cars").then()
                .statusCode(201);
        //update car
        given()
                .contentType("application/json")
                .body(updatedCar)
                .when().put("/cars/"+updatedCar.getLicensePlate()).then()
                .statusCode(200);
        // get the car and verify
        given()
                .when()
                .get("cars/123FFIO")
                .then()
                .statusCode(200)
                .and()
                .body("licensePlate",equalTo("123FFIO"))
                .body("type",equalTo("Camry"))
                .body("brand",equalTo("Toyota"))
                .body("price",equalTo(25.32f))
                .body("status",equalTo("RENT"));
        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
    }

    @Test
    public void testSearchCarByType() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96f, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by type
        given()
                .queryParam("type", "Camry")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("123FFIO"))
                .body("cars.type", hasItem("Camry"))
                .body("cars.brand", hasItem("Toyota"))
                .body("cars.price", hasItem(25.32f))
                .body("cars.status", hasItem("AVAILABLE"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }

    @Test
    public void testSearchCarByBrand() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96f, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by brand
        given()
                .queryParam("brand", "Honda")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("456FFIO"))
                .body("cars.type", hasItem("Accord"))
                .body("cars.brand", hasItem("Honda"))
                .body("cars.price", hasItem(22.96f))
                .body("cars.status", hasItem("BOOKED"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }

    @Test
    public void testSearchCarByPrice() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by price
        given()
                .queryParam("price", "25.32")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("123FFIO"))
                .body("cars.type", hasItem("Camry"))
                .body("cars.brand", hasItem("Toyota"))
                .body("cars.price", hasItem(25.32f))
                .body("cars.status", hasItem("AVAILABLE"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }

    @Test
    public void testSearchCarByTypeAndBrand() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32f, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96f, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by price
        given()
                .queryParam("type", "Camry")
                .queryParam("brand", "Toyota")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("123FFIO"))
                .body("cars.type", hasItem("Camry"))
                .body("cars.brand", hasItem("Toyota"))
                .body("cars.price", hasItem(25.32f))
                .body("cars.status", hasItem("AVAILABLE"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }

    @Test
    public void testSearchCarByTypeAndPrice() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by type & price
        given()
                .queryParam("type", "Camry")
                .queryParam("price", "25.32")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("123FFIO"))
                .body("cars.type", hasItem("Camry"))
                .body("cars.brand", hasItem("Toyota"))
                .body("cars.price", hasItem(25.32f))
                .body("cars.status", hasItem("AVAILABLE"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }

    @Test
    public void testSearchCarByBrandAndPrice() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by brand & price
        given()
                .queryParam("brand", "Toyota")
                .queryParam("price", "25.32")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("123FFIO"))
                .body("cars.type", hasItem("Camry"))
                .body("cars.brand", hasItem("Toyota"))
                .body("cars.price", hasItem(25.32f))
                .body("cars.status", hasItem("AVAILABLE"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }

    @Test
    public void testSearchCarByTypeAndBrandAndPrice() {
        // add the car
        CarDTO car1 = new CarDTO("123FFIO", "Camry", "Toyota", 25.32, "AVAILABLE");
        CarDTO car2 = new CarDTO("456FFIO", "Accord", "Honda", 22.96, "BOOKED");
        given()
                .contentType("application/json")
                .body(car1)
                .when().post("/cars").then()
                .statusCode(201);
        given()
                .contentType("application/json")
                .body(car2)
                .when().post("/cars").then()
                .statusCode(201);

        // search car by type & brand & price
        given()
                .queryParam("type", "Camry")
                .queryParam("brand", "Toyota")
                .queryParam("price", "25.32")
                .when()
                .get("/cars/search")
                .then()
                .statusCode(200)
                .and()
                .body("cars.licensePlate", hasItem("123FFIO"))
                .body("cars.type", hasItem("Camry"))
                .body("cars.brand", hasItem("Toyota"))
                .body("cars.price", hasItem(25.32f))
                .body("cars.status", hasItem("AVAILABLE"));

        //cleanup
        given()
                .when()
                .delete("cars/123FFIO");
        given()
                .when()
                .delete("cars/456FFIO");
    }
}

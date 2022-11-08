package one.digitalinnovation.parking.controller;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    private void setUpTest() {
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                //.extract().response().body().prettyPrint();
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void whenCreateThenCheckIsCreated() {
        ParkingCreateDTO parkingCreateDTO = new ParkingCreateDTO();
        parkingCreateDTO.setColor("AMARELO");
        parkingCreateDTO.setLicense("TVD-4687");
        parkingCreateDTO.setModel("BRASILIA");
        parkingCreateDTO.setState("RS");


        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(parkingCreateDTO)
                .post("/parking")
                .then()
                //.extract().response().body().prettyPrint();
                .statusCode(HttpStatus.CREATED.value())
                .body("color", Matchers.equalTo("AMARELO"))
                .body("license", Matchers.equalTo("TVD-4687"))
                .body("model", Matchers.equalTo("BRASILIA"))
                .body("state", Matchers.equalTo("RS"));
    }
}
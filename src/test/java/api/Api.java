package api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Api {

    private final static String URL = "http://tl.af-ctf.ru/";
    public UserRegistrationData validData = UserRegistrationData.builder()
            .name("Ivanov Ivan")
            .email("Ivananovivan@gmail.com")
            .phoneNumber("89665845468")
            .password("123456789")
            .passwordValidation("123456789").build();
    @Test
    public void checkValidDataInput(){
        Assert.assertEquals(validDataRequest().getText(), "");
    }

    public ValidRegisterDataResponse validDataRequest(){
        return given()
                .contentType(ContentType.JSON)
                .body(new Register(validData))
                .when()
                .post("http://tl.af-ctf.ru/calluserforsignup")
                .then()
                .log()
                .all()
                .extract()
                .as(ValidRegisterDataResponse.class);
    }

}

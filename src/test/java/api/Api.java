package api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserTestDataFactory;

import static io.restassured.RestAssured.given;

public class Api {

    private final static String URL = "http://tl.af-ctf.ru/";
    public UserRegistrationData validData = UserTestDataFactory.getRandomValidUserRegistrationData();
    @Test
    public void checkValidDataInput(){
        Assert.assertEquals(RegistrationRequest(validData).getText(), "Достигнут лимит в 4 исходящих звонка в минуту или 30 вызовов в день для одного номера");
    }
    @Test
    public void checkValidDataForTimes(){
//        var userData = UserTestDataFactory.getRandomUserRegistrationData(data -> {
//            data.setEmail("another email");
//            data.setPassword("pass");
//        });
    }

    public ValidRegisterDataResponse RegistrationRequest(UserRegistrationData data){
        Specification.setSpecifications(Specification.requestSpec(URL), Specification.responseSpec());
        return given()
                .body(UserTestDataFactory.getRandomValidUserRegistrationData())
                .when()
                .post("http://tl.af-ctf.ru/calluserforsignup")
                .then()
                .log()
                .all()
                .extract()
                .as(ValidRegisterDataResponse.class);
    }

}

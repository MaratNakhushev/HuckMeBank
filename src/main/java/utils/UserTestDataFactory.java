package utils;

import api.UserRegistrationData;
import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class UserTestDataFactory {
    private static final Faker faker = new Faker();

        public static UserRegistrationData getRandomValidUserRegistrationData() {
            var password = faker.internet().password(8, 12);
            var firstNumOfPhoneNumber = "8";

             return new UserRegistrationData(
                     faker.name().fullName(),
                     faker.internet().emailAddress(),
                     firstNumOfPhoneNumber + faker.numerify("##########"),
                     password,
                     password
             );


//    public static UserRegistrationData getRandomVlidUserRegistrationData(Consumer<UserRegistrationData> customizer) {
//        var password = faker.internet().password(8, 12);
//        var firstNumOfPhoneNumber = "8";
//
//        var data = new UserRegistrationData(
//                faker.name().fullName(),
//                faker.internet().emailAddress(),
//                firstNumOfPhoneNumber + faker.numerify("##########"),
//                password,
//                password
//        );
//        customizer.accept(data);
//        return data;
    }
}

package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageObject.MainPage;
import ui.pageObject.RegistrationForm;
import ui.pageObject.ValidationCodeForm;
import api.UserRegistrationData;

public class UI extends BaseUI {
    public MainPage mainPage = new MainPage();
    public RegistrationForm registrationForm = new RegistrationForm();
    public ValidationCodeForm validationCodeForm = new ValidationCodeForm();
    public UserRegistrationData validData = UserRegistrationData.builder()
            .name("Ivanov Ivan")
            .email("Ivananovivan@gmail.com")
            .phoneNumber("89665845468")
            .password("123456789")
            .passwordValidation("123456789").build();

    @Test(groups = "Ui tests")
    public void checkValidDataInput() {
        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not open");

        registrationForm
                .inputAllData(validData)
                .clickRegistrationButton()
                .closeAlert();

        Assert.assertTrue(validationCodeForm.isDisplayed());
    }

    @Test(groups = "Ui tests")
    public void inputInvalidName() {
        registrationForm
                .inputAllData(validData)
                .inputName("a")
                .clickRegistrationButton();
        Assert.assertEquals(registrationForm.getNameErrorText(), "Ваше имя (ФИО) не должно быть короче 3 символов.", "Name error message does not match");

        registrationForm
                .inputName("@")
                .clickRegistrationButton();
        Assert.assertEquals(registrationForm.getNameErrorText(), "Имя может содержать только буквы английского и русского алфавита", "Name error message does not match");

    }

    @Test(groups = "Ui tests")
    public void checkSecondAlertMessage() {
        registrationForm
                .inputAllData(validData)
                .clickRegistrationButton()
                .closeAlert();
        validationCodeForm.exitValidationForm();

        registrationForm.clickRegistrationButton();
        Assert.assertEquals(registrationForm.getAlertText(), "Количество запросов достигло максимума,вы можете отправлять запрос один раз в 35 минут");

    }
}



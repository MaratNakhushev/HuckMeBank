package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageObject.RegistrationForm;
import ui.pageObject.MainPage;
import ui.pageObject.ValidationCodeForm;
import utils.UserRegistrationData;

public class UI extends BaseUI {
    public MainPage mainPage = new MainPage();
    public RegistrationForm registrationForm = new RegistrationForm();
    public ValidationCodeForm validationCodeForm = new ValidationCodeForm();
    public UserRegistrationData validData = new UserRegistrationData(
            "Ivanov Ivan",
            "Ivananovivan@gmail.com",
            "89665845468",
            "123456789",
            "123456789");

    @Test
    public void checkValidDataInput() {
        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not open");
        registrationForm
                .inputAllData(validData)
                .clickRegistrationButton()
                .closeAlert();
        Assert.assertTrue(validationCodeForm.isDisplayed());
    }

    @Test
    public void inputInvalidName() {
        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not open");
        registrationForm
                .inputAllData(validData)
                .inputName("")
                .clickRegistrationButton();
        String sdf = registrationForm.getTipToolText();
        Assert.assertEquals(registrationForm.getNameErrorText(), "Имя может содержать только буквы английского и русского алфавита", "Name error message does not match");

    }

    @Test
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



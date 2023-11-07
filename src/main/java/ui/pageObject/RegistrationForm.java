package ui.pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.UserRegistrationData;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm extends BaseForm {

    private final SelenideElement nameField = $(By.id("userName"));
    private final SelenideElement emailField = $(By.id("email"));
    private final SelenideElement phoneNumberField = $(By.id("phoneNumber"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement passwordValidationField = $(By.id("passwordValidation"));
    private final SelenideElement registerButton = $(By.id("submitLogin"));
    private final SelenideElement invalidNameMassage = nameField
            .closest(".signUpForm__data")
            .find(".signUpForm__errText");

    public RegistrationForm() {
        super($x("//form[@name='inputForAuth']"));
    }

    public RegistrationForm inputName(String name) {
        nameField.setValue(name);
        return new RegistrationForm();
    }

    public RegistrationForm inputEmail(String email) {
        emailField.setValue(email);
        return new RegistrationForm();

    }

    public void inputPhoneNumber(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber);
    }

    public void inputPassword(String password) {
        passwordField.setValue(password);
    }

    public void inputPasswordValidation(String passwordValidation) {
        passwordValidationField.setValue(passwordValidation);
    }

    public RegistrationForm inputAllData(UserRegistrationData allData) {
        inputName(allData.name);
        inputEmail(allData.email);
        inputPhoneNumber(allData.phoneNumber);
        inputPassword(allData.password);
        inputPasswordValidation(allData.passwordValidation);
        return this;
    }

    public RegistrationForm clickRegistrationButton() {
        registerButton.click();
        return this;
    }

    public RegistrationForm closeAlert() {
        switchTo().alert().accept();
        return this;
    }

    public String getAlertText() {
        return switchTo().alert().getText();
    }

    public String getNameErrorText() {
        return invalidNameMassage.getText();
    }

    public String getTipToolText() {
        return nameField.getAttribute("title");
    }
}

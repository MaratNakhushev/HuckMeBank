package api;

public class Register {
    public String userName;
    public String login;
    public String phoneNumber;
    public String password;
    public String passwordValidation;

    public Register(UserRegistrationData userData) {
        this.userName = userData.name;
        this.login = userData.email;
        this.phoneNumber = userData.phoneNumber;
        this.password = userData.password;
        this.passwordValidation = userData.passwordValidation;
    }
}


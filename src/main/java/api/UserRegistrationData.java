package api;

import lombok.Builder;

@Builder
public class UserRegistrationData {
    public String name;
    public String email;
    public String phoneNumber;
    public String password;
    public String passwordValidation;

}

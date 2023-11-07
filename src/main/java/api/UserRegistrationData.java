package api;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public class UserRegistrationData {
    public String name;
    public String email;
    public String phoneNumber;
    public String password;
    public String passwordValidation;

    public UserRegistrationData(String name, String email, String phoneNumber, String password, String passwordValidation) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.passwordValidation = passwordValidation;
    }
}

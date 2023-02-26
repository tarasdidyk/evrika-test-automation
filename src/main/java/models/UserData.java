package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static utils.RandomUtil.*;

@Builder
@Setter
@Getter
public class UserData {

    private String firstname;
    private String surname;
    private String phone;
    private String email;
    private String password;

    public static UserData getRandomUserData() {
        return UserData
                .builder()
                .firstname(getRandomFistName())
                .surname(getRandomLastName())
                .email(getRandomEmail())
                .phone(getRandomPhoneString())
                .password(getRandomPassword())
                .build();
    }
}
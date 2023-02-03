package ru.akalavan.dance.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Class SignUpRequest
 *
 * @author Вагин Михаил
 * date 21.01.2023
 */
@Data
public class SignUpRequest {

    @Email(message = "Email please")
    @NotBlank(message = "Email required")
    private String email;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String confirmPassword;
}

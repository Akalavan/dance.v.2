package ru.akalavan.dance.payload.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Class LoginRequest
 *
 * @author Вагин Михаил
 * date 21.01.2023
 */
@Data
public class LoginRequest {

    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}

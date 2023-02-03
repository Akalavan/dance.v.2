package ru.akalavan.dance.payload.response;

import lombok.Getter;

/**
 * Class InvalidLoginResponse
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
@Getter
public class InvalidLoginResponse {

    private final String username;
    private final String password;

    public InvalidLoginResponse() {
        this.username = "Invalid username";
        this.password = "Invalid password";
    }
}

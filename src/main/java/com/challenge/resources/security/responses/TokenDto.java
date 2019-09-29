package com.challenge.resources.security.responses;

public class TokenDto {

    private String token;

    public TokenDto setToken(String token) {
        this.token = token;
        return this;
    }

    public String getToken() {
        return token;
    }

    public static TokenDto make(String token)
    {
        return (new TokenDto())
                .setToken(token);
    }
}

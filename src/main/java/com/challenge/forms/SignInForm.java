package com.challenge.forms;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignInForm {

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotNull
    @Length(min = 4)
    private String senha;

    public SignInForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public SignInForm setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsernamePasswordAuthenticationToken create()
    {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}

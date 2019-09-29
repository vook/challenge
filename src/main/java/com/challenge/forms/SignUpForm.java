package com.challenge.forms;

import com.challenge.enums.Estado;
import com.challenge.models.Cliente;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignUpForm {

    @NotNull
    @NotEmpty
    @Length(max = 150)
    private String nome;

    @NotNull
    @NotEmpty
    @Email
    @Length(max = 150)
    private String email;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String senha;

    @NotNull
    @NotEmpty
    @Length(max = 150)
    private String rua;

    @NotNull
    @NotEmpty
    @Length(max = 100)
    private String cidade;

    @NotNull
    @NotEmpty
    @Length(max = 100)
    private String bairro;

    @NotNull
    @NotEmpty
    @Length(min = 8, max = 8)
    private String cep;

    @NotNull
    private Estado estado;

    public SignUpForm setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public SignUpForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public SignUpForm setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public SignUpForm setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public SignUpForm setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public SignUpForm setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public SignUpForm setCep(String cep) {
        this.cep = cep.replaceAll("/\\D/g", "");
        return this;
    }

    public SignUpForm setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public Cliente create()
    {
        return (new Cliente())
                .setNome(nome)
                .setEmail(email)
                .setSenha((new BCryptPasswordEncoder()).encode(senha))
                .setRua(rua)
                .setCidade(cidade)
                .setBairro(bairro)
                .setCep(cep)
                .setEstado(estado);
    }
}

package com.challenge.models;

import com.challenge.enums.Estado;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CLIENTES")
public class Cliente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private String rua;

    private String cidade;

    private String bairro;

    private String cep;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Integer getId() {
        return id;
    }

    public Cliente setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Cliente setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public Cliente setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Cliente setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Cliente setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Cliente setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cliente setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

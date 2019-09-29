package com.challenge.controllers;

import com.challenge.forms.SignInForm;
import com.challenge.forms.SignUpForm;
import com.challenge.models.Cliente;
import com.challenge.repositories.ClienteRepository;
import com.challenge.services.TokenService;
import com.challenge.resources.security.responses.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    @PostMapping("/sign_up")
    public ResponseEntity<TokenDto> signUp(@RequestBody @Valid SignUpForm form)
    {
        Cliente cliente = clienteRepository.save(form.create());
        String token = this.tokenService.generate(cliente);
        return ResponseEntity.ok(TokenDto.make(token));
    }

    @PostMapping("/sign_in")
    public ResponseEntity<TokenDto> signIn(@RequestBody @Valid SignInForm form)
    {
        try {
            Authentication auth = this.authManager.authenticate(form.create());
            Cliente cliente = (Cliente) auth.getPrincipal();
            String token = this.tokenService.generate(cliente);
            return ResponseEntity.ok(TokenDto.make(token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

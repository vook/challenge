package com.challenge.services;

import com.challenge.models.Cliente;
import com.challenge.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService
{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> cliente = this.clienteRepository.findByEmail(username);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        throw new UsernameNotFoundException("Credenciais Inválidas");
    }
}

package com.challenge.filters;

import com.challenge.models.Cliente;
import com.challenge.repositories.ClienteRepository;
import com.challenge.services.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Authentication extends OncePerRequestFilter {

    private TokenService tokenService;

    private ClienteRepository clienteRepository;

    public Authentication(TokenService tokenService, ClienteRepository clienteRepository)
    {
        this.tokenService = tokenService;
        this.clienteRepository = clienteRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        String token = getToken(request);
        if (tokenService.isValid(token)) {
            Cliente cliente = clienteRepository.findById(tokenService.getId()).get();
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    cliente,
                    null,
                    new ArrayList<>()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request)
    {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer")) {
            return null;
        }
        return token.substring(7);
    }
}

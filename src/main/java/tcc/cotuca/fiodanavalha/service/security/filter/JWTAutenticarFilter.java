package tcc.cotuca.fiodanavalha.service.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import tcc.cotuca.fiodanavalha.exception.SecurityException;
import tcc.cotuca.fiodanavalha.to.Usuario;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
    @Value("${tempoExpiracao}")
    private int TOKEN_EXPIRACAO;

    @Value("${senha_unica_jwt}")
    public static String TOKEN_SENHA;

    private final AuthenticationManager authenticationManager;


    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        try {
            var usuario =
                    new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha(), new ArrayList<>()));
        } catch (IOException e) {
            throw new SecurityException("Falha ao tentar autenticar usuario!");
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        var usuarioData = (Usuario) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
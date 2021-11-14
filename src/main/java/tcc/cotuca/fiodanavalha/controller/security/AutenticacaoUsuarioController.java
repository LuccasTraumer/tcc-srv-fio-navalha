package tcc.cotuca.fiodanavalha.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import tcc.cotuca.fiodanavalha.config.JwtUtils;
import tcc.cotuca.fiodanavalha.exception.AuthException;
import tcc.cotuca.fiodanavalha.to.auth.JwtRequest;
import tcc.cotuca.fiodanavalha.to.auth.JwtResponse;

@RestController
@CrossOrigin
@RequestMapping
public class AutenticacaoUsuarioController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(
            @RequestBody JwtRequest authenticationRequest) throws AuthException {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final var userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final var token = JwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws AuthException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthException("INVALID_CREDENTIALS", e);
        }
    }
}

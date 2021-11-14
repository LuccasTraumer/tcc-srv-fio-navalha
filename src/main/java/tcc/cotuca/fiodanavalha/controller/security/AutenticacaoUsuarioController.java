//package tcc.cotuca.fiodanavalha.controller.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//import tcc.cotuca.fiodanavalha.config.JwtUtils;
//import tcc.cotuca.fiodanavalha.exception.SecurityException;
//import tcc.cotuca.fiodanavalha.to.security.JwtRequest;
//import tcc.cotuca.fiodanavalha.to.security.JwtResponse;
//
//@RestController
//@CrossOrigin
//@RequestMapping
//public class AutenticacaoUsuarioController {
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping(value = "/authenticate")
//    public ResponseEntity<JwtResponse> createAuthenticationToken(
//            @RequestBody JwtRequest authenticationRequest) throws SecurityException {
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//        final var userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//        final var token = JwtUtils.gerarToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//    private void authenticate(String username, String password) throws SecurityException {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new SecurityException("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new SecurityException("INVALID_CREDENTIALS", e);
//        }
//    }
//}

package tcc.cotuca.fiodanavalha.config;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtils implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private static String secret;

    public static String pegarUsernameToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public static Date pegarDataExpiracaoToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public static  <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);

    }

    private static Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private static Boolean tokenEstaExpirado(String token) {
        final Date expiration = pegarDataExpiracaoToken(token);
        return expiration.before(new Date());
    }

    public static String gerarToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return efetuarGeracaoToken(claims, userDetails.getUsername());
    }

    private static String efetuarGeracaoToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public static Boolean validarToken(String token, UserDetails userDetails) {
        final String username = pegarUsernameToken(token);
        return (username.equals(userDetails.getUsername()) && !tokenEstaExpirado(token));
    }
}

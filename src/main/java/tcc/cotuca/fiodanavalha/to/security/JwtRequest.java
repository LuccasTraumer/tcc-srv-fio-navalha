package tcc.cotuca.fiodanavalha.to.auth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


public class JwtRequest implements UserDetails {

    private static final long serialVersionUID = 5926468583005150707L;

    private final Optional<Usuario> usuario;

    public JwtRequest(final Optional<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.usuario.isPresent() && this.usuario.get().getSenha() != null ?  this.usuario.get().getPassword() : null;
    }

    @Override
    public String getUsername() {
        return this.usuario.isPresent() && this.usuario.get().getUsername() != null ?  this.usuario.get().getUsername() : null;
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

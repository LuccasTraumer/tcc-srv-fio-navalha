package tcc.cotuca.fiodanavalha.to.perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import tcc.cotuca.fiodanavalha.to.Endereco;

@Data
@AllArgsConstructor
public class PerfilResponse {
    private String nome;
    private Endereco endereco;
    private String email;
    private String telefone;
    private Object fotoPerfil;
}

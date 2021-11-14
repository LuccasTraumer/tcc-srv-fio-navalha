package tcc.cotuca.fiodanavalha.to.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tcc.cotuca.fiodanavalha.to.Endereco;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {
    private String email;
    private String cpf;
    private String telefone;
    private String nome;
    private Object fotoPerfil;
    private Object id;
    private BigDecimal saldoCliente;
    private Endereco endereco;
    private Class tipoCliente;

}

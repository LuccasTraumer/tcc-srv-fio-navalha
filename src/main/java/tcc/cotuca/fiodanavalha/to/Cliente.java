package tcc.cotuca.fiodanavalha.to;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

@Data
@Entity
public abstract class Cliente {
    Cliente(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private Cliente tipoCliente;
    private String fotoPerfil;
    private String senha;
    private Date dataNascimento;
    private Date dataCadastro;
}
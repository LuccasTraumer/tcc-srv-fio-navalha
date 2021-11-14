package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

@Entity(name = "endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;
    private String cep;
    private String numeroResidencia;
}

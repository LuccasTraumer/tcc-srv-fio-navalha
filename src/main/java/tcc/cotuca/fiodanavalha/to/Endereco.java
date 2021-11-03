package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private String id;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;
    private String cep;
    private String numeroResidencia;
}

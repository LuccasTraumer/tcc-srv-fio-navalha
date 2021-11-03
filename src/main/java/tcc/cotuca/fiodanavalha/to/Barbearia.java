package tcc.cotuca.fiodanavalha.to;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "barbearia")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Data
public class Barbearia extends Usuario {
    private List<Object> horariosDiponiveis;
    private String especialidade;
    private List<Cabeleleiro> listaCabeleleiro;
    private List<Endereco> enderecos;
    private Endereco endereco;
    private String cnpj;

}

package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorServico {
    private String nome;
    private Double avaliacao;
    private List<String> comentarios;
}

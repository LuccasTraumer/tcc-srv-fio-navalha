package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cabeleleiro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cabeleleiro extends Usuario {
    private Double favorito;
    private Comentario comentario;
    private Double notaCliente;
    private Double reputacao;
}

package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "cabeleleiro")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cabeleleiro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCabeleleiro;

    private String name;
    private Double anosExperiencia;
    private Double reputacao;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(Double anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public Double getReputacao() {
        return reputacao;
    }

    public void setReputacao(Double reputacao) {
        this.reputacao = reputacao;
    }
}

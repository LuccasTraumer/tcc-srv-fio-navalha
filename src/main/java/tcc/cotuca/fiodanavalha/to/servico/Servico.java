package tcc.cotuca.fiodanavalha.to.servico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@ToString
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private LocalDate dataServico;
    private LocalDateTime inicioCorte;
    private LocalDateTime fimCorte;
    private BigDecimal valorCorte;

    public Long tempoCorte() {
        return ChronoUnit.HOURS.between(inicioCorte, fimCorte);
    }

}

package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Planos {
    private BigDecimal valorMensalidade;
    private Integer quantidadePassesLivres;
    private Integer quantidadePassesUtilizados;
    private LocalDate dataPagamentoMensalidade;
}

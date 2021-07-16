package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@AllArgsConstructor
public class Corte {
    private ClienteVarejo consumidor;
    private ClienteBarbearia barbearia;
    private LocalDateTime inicioCorte;
    private LocalDateTime fimCorte;
    private BigDecimal valorCorte;

    public Long tempoCorte() {
        return ChronoUnit.HOURS.between(inicioCorte, fimCorte);
    }

    public void avaliarConsumidor(final Double nota) {
        this.consumidor.setNotaCliente(nota);
    }

    public void avaliarBarbearia(final Double nota) {
        this.barbearia.setAvaliacaoBarbearia(nota);
    }

    public void avaliarPrestadorServico(final String nome, final Double nota) {
        this.barbearia.getPrestadoresServico().forEach(prestadorServico -> {
            if(prestadorServico.getNome().equals(nome))
                prestadorServico.setAvaliacao(nota);
        });
    }
}

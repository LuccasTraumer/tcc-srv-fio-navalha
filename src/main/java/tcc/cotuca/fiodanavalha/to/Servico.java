package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@ToString
public class Servico {
    private Cliente consumidor;
    private Barbearia barbearia;
    private String name;
    private LocalDate dataServico;
    private LocalDateTime inicioCorte;
    private LocalDateTime fimCorte;
    private BigDecimal valorCorte;

    public Long tempoCorte() {
        return ChronoUnit.HOURS.between(inicioCorte, fimCorte);
    }

    public void avaliarPrestadorServico(final String nome, final Double nota) {
        this.barbearia.getPrestadoresServico().forEach(prestadorServico -> {
            if(prestadorServico.getNome().equals(nome))
                prestadorServico.setReputacao(nota);
        });
    }
}

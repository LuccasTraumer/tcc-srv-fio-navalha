package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barbearia")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Barbearia extends Usuario {
    private List<LocalDateTime> agendaDisponivel;
    private Double avaliacaoBarbearia;
    private List<String> enderecosBarbearia;
    private String especialidade;
    private Double tempoMedio;
    private Double precoMedio;
    private List<LocalDateTime> horarioFuncionamento;
    private List<Servico> servicosRealizados;
    private List<String> comentariosSobre;
    private List<PlanoDisponibilizado> tiposPlanos;
    private List<Cabeleleiro> prestadoresServico;

    public Barbearia() {
        this.agendaDisponivel = new ArrayList<>();
        this.avaliacaoBarbearia = 0.0;
        this.enderecosBarbearia = new ArrayList<>();
        this.especialidade = "";
        this.tempoMedio = 0.0;
        this.precoMedio = 0.0;
        this.horarioFuncionamento = new ArrayList<>();
        this.servicosRealizados = new ArrayList<>();
        this.comentariosSobre = new ArrayList<>();
        this.tiposPlanos = new ArrayList<>();
    }
}

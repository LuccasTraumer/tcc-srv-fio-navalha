package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Barbearia extends Usuario {
    private List<LocalDateTime> agendaDisponivel;
    private Double avaliacaoBarbearia;
    private List<String> enderecosBarbearia;
    private String especialidade;
    private Double tempoMedio;
    private Double precoMedio;
    private String descricao;
    private List<LocalDateTime> horarioFuncionamento;
    private List<Servico> servicosRealizados;
    private List<String> comentariosSobre;
    private List<PlanoDisponibilizado> tiposPlanos;
    private List<PrestadorServico> prestadoresServico;

    public Barbearia() {
        this.agendaDisponivel = new ArrayList<>();
        this.avaliacaoBarbearia = 0.0;
        this.enderecosBarbearia = new ArrayList<>();
        this.especialidade = "";
        this.tempoMedio = 0.0;
        this.precoMedio = 0.0;
        this.descricao = "";
        this.horarioFuncionamento = new ArrayList<>();
        this.servicosRealizados = new ArrayList<>();
        this.comentariosSobre = new ArrayList<>();
        this.tiposPlanos = new ArrayList<>();
    }
}

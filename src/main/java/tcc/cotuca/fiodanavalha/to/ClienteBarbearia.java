package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
public class ClienteBarbearia extends Cliente {
    private List<LocalDateTime> agendaDisponivel;
    private Double avaliacaoBarbearia;
    private List<String> enderecosBarbearia;
    private String especialidade;
    private Integer tempoMedio;
    private Double precoMedio;
    private String descricao;
    private BigDecimal mensalidade;
    private List<LocalDateTime> horarioFuncionamento;
    private List<Corte> servicosRealizados;
    private List<String> comentariosSobre;
    private List<String> tiposPlanos;
    private List<PrestadorServico> prestadoresServico;

    public ClienteBarbearia() {
        this.agendaDisponivel = new ArrayList<>();
        this.avaliacaoBarbearia = 0.0;
        this.enderecosBarbearia = new ArrayList<>();
        this.especialidade = "";
        this.tempoMedio = 0;
        this.precoMedio = 0.0;
        this.descricao = "";
        this.mensalidade = new BigDecimal(0);
        this.horarioFuncionamento = new ArrayList<>();
        this.servicosRealizados = new ArrayList<>();
        this.comentariosSobre = new ArrayList<>();
        this.tiposPlanos = new ArrayList<>();
    }
}

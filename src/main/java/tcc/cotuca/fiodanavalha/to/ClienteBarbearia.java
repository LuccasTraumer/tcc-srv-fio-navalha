package tcc.cotuca.fiodanavalha.to;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ClienteBarbearia extends Cliente {
    private String agendaDisponivel;
    private Double avaliacaoBarbearia;
    private List<String> enderecosBarbearia;
    private String especialidade;
    private Integer tempoMedio;
    private Double precoMedio;
    private String descricao;
    private BigDecimal mensalidade;
    private Date horarioDisponivel;
    private List<Corte> servicosRealizados;
    private List<String> comentariosSobre;
    private List<String> tiposPlanos;
}

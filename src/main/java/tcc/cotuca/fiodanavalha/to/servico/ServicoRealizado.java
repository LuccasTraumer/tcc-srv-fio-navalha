package tcc.cotuca.fiodanavalha.to.servico;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ServicoRealizado {
    private Integer idServico;
    private Integer idCliente;
    private Integer idBarbearia;
    private Integer idFeedback;
}

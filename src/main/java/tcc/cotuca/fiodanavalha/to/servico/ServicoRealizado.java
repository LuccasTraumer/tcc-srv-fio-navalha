package tcc.cotuca.fiodanavalha.to.servico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRealizado {
    private Long idServico;
    private Long idCliente;
    private Long idBarbearia;
    private Long idFeedback ;
}

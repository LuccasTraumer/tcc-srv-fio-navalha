package tcc.cotuca.fiodanavalha.to.home;

import lombok.*;
import tcc.cotuca.fiodanavalha.to.servico.Servico;
import tcc.cotuca.fiodanavalha.to.servico.ServicoSolicitado;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HomeBarbeariaResponse {
    //TODO: Ajustar o tipo da lista de Horarios Disponiveis
    private List<ServicoSolicitado> listaPedido;
    private List<Servico> listaHorariosDisponiveis;
}

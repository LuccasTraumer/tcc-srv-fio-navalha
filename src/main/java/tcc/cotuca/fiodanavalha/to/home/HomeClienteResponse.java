package tcc.cotuca.fiodanavalha.to.home;

import lombok.*;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.servico.Servico;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HomeClienteResponse {
    private List<Servico> listaDeServicos;
    private List<Barbearia> listaBarbeariasVisitadas;
    private List<Barbearia> listaBarbeariasFavotitas;
}

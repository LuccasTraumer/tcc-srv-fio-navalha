package tcc.cotuca.fiodanavalha.to.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchResponse {
    private List<Barbearia> listaBarbeariaFavorita;
    private List<Barbearia> listaBarbeariaFiltro;
}

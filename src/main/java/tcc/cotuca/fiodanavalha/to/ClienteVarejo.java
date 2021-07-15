package tcc.cotuca.fiodanavalha.to;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Data
@Entity
public class ClienteVarejo extends Cliente {
    private BigDecimal saldoCarteira;
    private Double notaCliente;
    private List<ClienteBarbearia> listaBarbeariasFavoritas;
    private List<String> comentarios;
    private Double reputacao;
    private List<String> listaServicoConsumidos;
}
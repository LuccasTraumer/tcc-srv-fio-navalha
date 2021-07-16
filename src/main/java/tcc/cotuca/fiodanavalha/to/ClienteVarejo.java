package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
@AllArgsConstructor
public class ClienteVarejo extends Cliente {
    private BigDecimal saldoCarteira;
    private Double notaCliente;
    private List<ClienteBarbearia> listaBarbeariasFavoritas;
    private List<String> comentarios;
    private Double reputacao;
    private List<String> listaServicoConsumidos;

    public ClienteVarejo() {
        this.saldoCarteira = new BigDecimal(0);
        this.notaCliente = 0.0;
        this.listaBarbeariasFavoritas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.reputacao = 0.0;
        this.listaServicoConsumidos = new ArrayList<>();
    }
}
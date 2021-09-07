package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Slf4j
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Cliente extends Usuario {
    private BigDecimal saldoCliente;
    private Double notaCliente;
    private List<Barbearia> listaBarbeariasFavoritas;
    private List<String> comentarios;
    private Double reputacao;
    private List<String> listaServicoConsumidos;
    private PlanoContratado planoContratado;
    private Endereco endereco;

    public Cliente() {
        this.saldoCliente = new BigDecimal(0);
        this.notaCliente = 0.0;
        this.listaBarbeariasFavoritas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.reputacao = 0.0;
        this.listaServicoConsumidos = new ArrayList<>();
        this.endereco = new Endereco();
    }
}
package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import tcc.cotuca.fiodanavalha.to.plano.PlanoContratado;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
@Slf4j
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Cliente extends Usuario {
    private BigDecimal saldoCliente;
    private Double notaCliente;
    private Double reputacao;
    private PlanoContratado planoContratado;
    private Endereco endereco;

    public Cliente() {
        this.saldoCliente = new BigDecimal(0);
        this.notaCliente = 0.0;
        this.reputacao = 0.0;
        this.endereco = new Endereco();
    }

    public BigDecimal getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(BigDecimal saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public Double getNotaCliente() {
        return notaCliente;
    }

    public void setNotaCliente(Double notaCliente) {
        this.notaCliente = notaCliente;
    }

    public Double getReputacao() {
        return reputacao;
    }

    public void setReputacao(Double reputacao) {
        this.reputacao = reputacao;
    }

    public PlanoContratado getPlanoContratado() {
        return planoContratado;
    }

    public void setPlanoContratado(PlanoContratado planoContratado) {
        this.planoContratado = planoContratado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
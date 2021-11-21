package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;
import tcc.cotuca.fiodanavalha.to.plano.PlanoContratado;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cliente")
@Slf4j
@AllArgsConstructor
@ToString
public class Cliente extends Usuario {
    private BigDecimal saldoCliente;
    private Double notaCliente;
    private Double reputacao;
    private PlanoContratado planoContratado;
    private String cpf;

    public Cliente() {
        this.saldoCliente = new BigDecimal(0);
        this.notaCliente = 0.0;
        this.reputacao = 0.0;
        this.cpf = "";
    }

    public Cliente(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        var cliente = (Cliente) o;
        return Objects.equals(
                getSaldoCliente(), cliente.getSaldoCliente()) &&
                Objects.equals(getNotaCliente(), cliente.getNotaCliente()) &&
                Objects.equals(getReputacao(), cliente.getReputacao()) &&
                Objects.equals(getPlanoContratado(), cliente.getPlanoContratado()) &&
                Objects.equals(getCpf(), cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSaldoCliente(), getNotaCliente(),
                        getReputacao(), getPlanoContratado(), getCpf());
    }

    public Cliente (Cliente cliente) throws FioDaNavalhaException {
        if (cliente == null)
            throw new FioDaNavalhaException("Modelo para copia está ausente!");

        this.mudarAtributosUsuario(cliente);
        this.saldoCliente = cliente.saldoCliente;
        this.notaCliente = cliente.notaCliente;
        this.reputacao = cliente.reputacao;
        this.planoContratado = cliente.planoContratado;
        this.cpf = cliente.cpf;

    }

    @Override
    public Object clone () {
        Cliente ret = null;

        try {
            ret = new Cliente(this);
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        return ret;
    }

    private void mudarAtributosUsuario(Cliente barbearia) {
        this.setNome(barbearia.getNome());
        this.setEmail(barbearia.getEmail());
        this.setDescricao(barbearia.getDescricao());
        this.setTelefone(barbearia.getTelefone());
        this.setFotoPerfil(barbearia.getFotoPerfil());
        this.setSenha(barbearia.getSenha());
        this.setDataNascimento(barbearia.getDataNascimento());
        this.setDataCadastro(barbearia.getDataCadastro());
    }
}
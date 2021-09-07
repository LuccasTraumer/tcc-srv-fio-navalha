package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String tipoCliente;
    private String fotoPerfil;
    private String senha;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String descricao;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty() || nome.isBlank())
            throw new FioDaNavalhaException("Nome informado é invalido!");
        else
            this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        if (cpfCnpj.isEmpty() || cpfCnpj.isBlank())
            throw new FioDaNavalhaException("Cpf/Cnpj informado é invalido!");
        else
            this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente.isEmpty() || tipoCliente.isBlank())
            throw new FioDaNavalhaException("Tipo de Cliente informado é invalido!");
        else
            this.tipoCliente = tipoCliente;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.isEmpty() || senha.isBlank())
            throw new FioDaNavalhaException("Senha informado é invalido!");
        else
            this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
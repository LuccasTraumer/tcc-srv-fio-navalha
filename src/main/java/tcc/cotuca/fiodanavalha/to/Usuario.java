package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Id;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;

import javax.persistence.GeneratedValue;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private String id;
    private String nome;
    private String descricao;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String fotoPerfil;
    private String senha;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

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
package tcc.cotuca.fiodanavalha.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Object id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private String email;

    private String telefone;

    private String nome;
    private String descricao;


    private Endereco endereco;
    private String fotoPerfil;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

    public Object getId() {
        return id;
    }

    public String getNome() {
        return new String(nome);
    }

    public void setNome(String nome) {
        if (nome.isEmpty() || nome.isBlank() || nome.length() < 3)
            throw new FioDaNavalhaException("Nome informado é invalido!");
        else
            this.nome = nome;
    }

    public String getEmail() {
        return new String(email);
    }

    public void setEmail(String email) {
        if (!(email.contains(".com") || email.contains("@")) || email.length() < 5)
            throw new CadastroInvalidoException("Email invalido para criação de usuario!");
        this.email = email.trim();
    }

    public String getTelefone() {
        return new String(telefone);
    }

    public void setTelefone(String telefone) {
        if (telefone.length() < 8)
            throw new CadastroInvalidoException("Telefone Invalido para Cadastro!");
        this.telefone = telefone;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getSenha() {
        return new String(senha);
    }

    public void setSenha(String senha) {
        if (senha.isEmpty() || senha.isBlank() || senha.length() < 3)
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
        return new String(descricao);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        var usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getDescricao(), usuario.getDescricao()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getTelefone(), usuario.getTelefone()) && Objects.equals(getFotoPerfil(), usuario.getFotoPerfil()) && Objects.equals(getSenha(), usuario.getSenha()) && Objects.equals(getDataNascimento(), usuario.getDataNascimento()) && Objects.equals(getDataCadastro(), usuario.getDataCadastro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(),
                        getDescricao(), getEmail(),
                        getTelefone(), getFotoPerfil(),
                        getSenha(), getDataNascimento(), getDataCadastro());
    }

    public void generatedId(Usuario usuario) {
        if(id == null)
            id = (long) usuario.hashCode();
    }

    public Object clone () {
        return null;
    }
}
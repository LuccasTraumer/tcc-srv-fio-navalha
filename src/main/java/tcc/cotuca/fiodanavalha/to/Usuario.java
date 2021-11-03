package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;

import javax.persistence.GeneratedValue;

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
    private Long id;

    private String nome;
    private String descricao;
    private String email;
    private String telefone;
    private Object fotoPerfil;
    private String senha;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

    public Long getId() {
        Long clone = Long.valueOf(id);
        return clone;
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

    public Object getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Object fotoPerfil) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getDescricao(), usuario.getDescricao()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getTelefone(), usuario.getTelefone()) && Objects.equals(getFotoPerfil(), usuario.getFotoPerfil()) && Objects.equals(getSenha(), usuario.getSenha()) && Objects.equals(getDataNascimento(), usuario.getDataNascimento()) && Objects.equals(getDataCadastro(), usuario.getDataCadastro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDescricao(), getEmail(), getTelefone(), getFotoPerfil(), getSenha(), getDataNascimento(), getDataCadastro());
    }

    public void generatedId(Usuario usuario) {
        if(id == null)
            id = Long.valueOf(usuario.hashCode());
    }
}
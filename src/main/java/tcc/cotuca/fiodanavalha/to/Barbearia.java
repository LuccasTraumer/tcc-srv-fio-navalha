package tcc.cotuca.fiodanavalha.to;

import lombok.*;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barbearia")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Data
public class Barbearia extends Usuario {
    private List<Object> horariosDiponiveis;
    private String especialidade;
    private List<Cabeleleiro> listaCabeleleiro;
    private List<Endereco> enderecos;
    private String cnpj;

    public Barbearia() {
        this.listaCabeleleiro = new ArrayList<>();
        this.enderecos = new ArrayList<>();
        this.horariosDiponiveis = new ArrayList<>();
    }

    public Barbearia (Barbearia barbearia) throws FioDaNavalhaException {
        if (barbearia == null)
            throw new FioDaNavalhaException("Modelo para copia está ausente!");

        this.mudarAtributosUsuario(barbearia);
        this.especialidade = barbearia.especialidade;
        this.cnpj = barbearia.cnpj;

        this.enderecos = new ArrayList<>(barbearia.enderecos);
        this.listaCabeleleiro = new ArrayList<>(barbearia.listaCabeleleiro);
        this.horariosDiponiveis = new ArrayList<>(barbearia.horariosDiponiveis);
    }

    @Override
    public Object clone () {
        Barbearia ret = null;

        try {
            ret = new Barbearia(this);
        } catch (Exception erro) {}
        return ret;
    }

    private void mudarAtributosUsuario(Barbearia barbearia) {
        this.setNome(barbearia.getNome());
        this.setDescricao(barbearia.getDescricao());
        this.setFotoPerfil(barbearia.getFotoPerfil());
        this.setSenha(barbearia.getSenha());
        this.setDataNascimento(barbearia.getDataNascimento());
        this.setDataCadastro(barbearia.getDataCadastro());
        this.setEndereco(barbearia.getEndereco());

        if (barbearia.getEmail().isEmpty())
            this.setTelefone(barbearia.getTelefone());
        else
            this.setEmail(barbearia.getEmail());
    }
}

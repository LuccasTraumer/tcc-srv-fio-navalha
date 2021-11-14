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
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Data
public class Barbearia extends Usuario {
    private List<Object> horariosDiponiveis;
    private String especialidade;
    private List<Cabeleleiro> listaCabeleleiro;
    private List<Endereco> enderecos;
    private Endereco endereco;
    private String cnpj;

    public Barbearia (Barbearia barbearia) throws FioDaNavalhaException {
        if (barbearia == null)
            throw new FioDaNavalhaException("Modelo para copia está ausente!");

        this.mudarAtributosUsuario(barbearia);
        this.especialidade = barbearia.especialidade;
        this.endereco = barbearia.endereco;
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
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        return ret;
    }

    private void mudarAtributosUsuario(Barbearia barbearia) {
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

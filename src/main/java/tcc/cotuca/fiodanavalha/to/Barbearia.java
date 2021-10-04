package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barbearia")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Barbearia {
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
    private List<Object> horariosDiponiveis;
    private String especialidade;
    private List<Cabeleleiro> listaCabeleleiro;


    public Barbearia() {
        this.especialidade = "";
        this.horariosDiponiveis = new ArrayList<>();
        this.listaCabeleleiro = new ArrayList<>();
    }

    public List<Object> getHorariosDiponiveis() {
        return horariosDiponiveis;
    }

    public void setHorariosDiponiveis(List<Object> horariosDiponiveis) {
        this.horariosDiponiveis = horariosDiponiveis;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Cabeleleiro> getListaCabeleleiro() {
        return listaCabeleleiro;
    }

    public void setListaCabeleleiro(List<Cabeleleiro> listaCabeleleiro) {
        this.listaCabeleleiro = listaCabeleleiro;
    }
}

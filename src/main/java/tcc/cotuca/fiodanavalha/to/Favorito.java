package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity(name = "favorito")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Cliente cliente;
    private Barbearia barbearia;
}

package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "avaliacao")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer idAvaliacao;
    private final Double notaAvaliacao;


}

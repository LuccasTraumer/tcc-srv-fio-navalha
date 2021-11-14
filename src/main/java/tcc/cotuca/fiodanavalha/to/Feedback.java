package tcc.cotuca.fiodanavalha.to;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

@Entity(name = "feedback")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFeedback;
    private Avaliacao avaliacao;
    private String comentario;
}

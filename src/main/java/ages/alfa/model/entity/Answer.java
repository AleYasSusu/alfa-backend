package ages.alfa.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answer", schema = "public")
public class Answer implements Serializable {

    public static final long serialVersionUID = -9187924262815607891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "letter")
    private String letter;

    @Column(name = "response")
    private String response;

    @Column(name = "is_correct_response")
    private boolean isCorrectResponse;

}

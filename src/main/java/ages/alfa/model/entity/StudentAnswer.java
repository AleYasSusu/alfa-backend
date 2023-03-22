package ages.alfa.model.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_answer", schema = "public",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"student_id", "activity_id"}))
public class StudentAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "alternative_id", nullable = false)
    private Alternative alternative;

    @Column(name = "correct_answer")
    private Boolean correctAnswer;


}

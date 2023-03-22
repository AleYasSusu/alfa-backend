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
@Table(name = "class", schema = "public")
public class Class implements Serializable {

    public static final long serialVersionUID = 4944163854215316604L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, unique = true)
    private Teacher teacher;

    @Column(name = "name")
    private String name;

    @Column(name = "url_invite")
    private String urlInvite;

    @Column(name = "hash")
    private String hash;

}

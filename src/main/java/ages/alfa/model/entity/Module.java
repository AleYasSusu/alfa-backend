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
@Table(name = "module", schema = "public")
public class Module implements Serializable {

    public static final long serialVersionUID = -7991541746658926932L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false, unique = true)
    private Class classz;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "description", length = 256)
    private String description;

}

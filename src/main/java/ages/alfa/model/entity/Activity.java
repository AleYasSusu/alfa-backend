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
@Table(name = "activity", schema = "public")
public class Activity implements Serializable {

    public final static long serialVersionUID = 1975980407645529579L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @Column(name = "text", length = 256)
    private String text;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "url_img")
    private String urlImg;
    
}

package ages.alfa.model.entity;

import ages.alfa.model.IActivity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson", schema = "public")
public class Lesson implements IActivity, Serializable {

    public static final long serialVersionUID = 1711366945297251545L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @Column(name = "text", length = 4092)
    private String text;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "activities")
    private Integer activities;

}
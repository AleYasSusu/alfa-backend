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
@Table(name = "address", schema = "public")
public class Address implements Serializable {

    public static final long serialVersionUID = -4352896010306776368L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line1")
    private String firstLine;

    @Column(name = "line2")
    private String secondLine;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
}

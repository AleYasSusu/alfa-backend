package ages.alfa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateClassRequest implements Serializable {

    private static final long serialVersionUID = 4962819622007467796L;

    private String name;

}

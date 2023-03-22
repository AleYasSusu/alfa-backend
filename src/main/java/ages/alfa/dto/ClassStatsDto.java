package ages.alfa.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassStatsDto {

    private String className;
    private String teacherName;
    private int students;
    private int modules;
    private int lessons;
    private int activities;
    private List<StudentStatsDto> studentStatsDtoList;
}

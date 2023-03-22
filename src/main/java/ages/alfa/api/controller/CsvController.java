package ages.alfa.api.controller;

import ages.alfa.dto.ClassStatsDto;
import ages.alfa.dto.StudentStatsDto;
import ages.alfa.model.entity.*;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Module;
import ages.alfa.repository.*;
import ages.alfa.service.impl.StudentStatsExcelExporterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.poi.util.IOUtils;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/csv")
@RequiredArgsConstructor
public class CsvController {

    private final LessonRepository lessonRepository;
    private final ClassRepository classRepository;
    private final ModuleRepository moduleRepository;
    private final ClassStudentRepository classStudentRepository;
    private final ActivityRepository activityRepository;
    private final StudentAnswerRepository studentAnswerRepository;

    @GetMapping("/{classId}/download")
    public void downloadCsv(@PathVariable("classId") final Long classId, HttpServletResponse response) throws IOException {

        ClassStatsDto classStatsDto = getClassStats(classId);
        StudentStatsExcelExporterServiceImpl studentStatsExcelExporterService = new StudentStatsExcelExporterServiceImpl(classStatsDto.getStudentStatsDtoList());
        studentStatsExcelExporterService.write();

        response.setContentType("application/octet-stream");


        String fileName = classStatsDto.getClassName().replaceAll("\\s+", "_");
        fileName = "Alfa_" + fileName;

        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        studentStatsExcelExporterService.getWorkbook().write(outputStream);

        ByteArrayInputStream stream = new ByteArrayInputStream(outputStream.toByteArray());
        IOUtils.copy(stream, response.getOutputStream());
    }


    @GetMapping("/{classId}")
    public ClassStatsDto getClassStats(@PathVariable("classId") final Long classId) {

        Class xClass = classRepository.findById(classId).get();

        List<StudentStatsDto> studentStatsDtoList = new ArrayList<>();

        ClassStudent classStudent = ClassStudent.builder().classz(Class.builder().id(classId).build()).build();
        List<ClassStudent> classStudentList = classStudentRepository.findAll(Example.of(classStudent));

        Module module = Module.builder().classz(Class.builder().id(classId).build()).build();
        List<Module> moduleList = moduleRepository.findAll(Example.of(module));


        List<Activity> activityList = new ArrayList<>();

        for (Module m : moduleList) {
            Activity activity = Activity.builder().module(m).build();
            activityList.addAll(activityRepository.findAll(Example.of(activity)));
        }

        ClassStatsDto classStatsDto = ClassStatsDto.builder()
                .className(xClass.getName())
                .students(classStudentList.size())
                .teacherName(xClass.getTeacher().getUser().getName())
                .modules(moduleList.size())
                .activities(activityList.size()).build();


        List<Lesson> lessonList = new ArrayList<>();
        for (Module m : moduleList) {
            lessonList.addAll(lessonRepository.findAll(Example.of(Lesson.builder().module(m).build())));
        }

        classStatsDto.setLessons(lessonList.size());

        for (ClassStudent cs : classStudentList) {

            // Todos os alunos da classe passada por parâmetro
            if (cs.getClassz().getId() == classId) {
                StudentStatsDto studentStatsDto = StudentStatsDto.builder()
                        .studentName(cs.getStudent().getUser().getName())
                        .email(cs.getStudent().getUser().getEmail())
                        .activitiesAnswered(0)
                        .activitiesCorrect(0)
                        .activitiesWrong(0)
                        .studentId(cs.getStudent().getId())
                        .build();

                // Todas as resposta do aluno
                Student student = Student.builder().id(cs.getStudent().getId()).build();
                StudentAnswer studentAnswer = StudentAnswer.builder().student(student).build();
                List<StudentAnswer> studentAnswerList = studentAnswerRepository.findAll(Example.of(studentAnswer));

                studentStatsDto.setActivitiesAnswered(studentAnswerList.size());

                for (StudentAnswer sa : studentAnswerList) {

                    // Verifica se a atividade do aluno faz parte das atividades da classe passada por parâmtro
                    for (Activity a : activityList) {
                        if (a.getId() == sa.getActivity().getId()) {

                            if (sa.getCorrectAnswer()) {
                                studentStatsDto.setActivitiesCorrect(studentStatsDto.getActivitiesCorrect() + 1);
                            } else {
                                studentStatsDto.setActivitiesWrong(studentStatsDto.getActivitiesWrong() + 1);
                            }
                        }
                    }
                }
                studentStatsDtoList.add(studentStatsDto);
            }
        }

        classStatsDto.setStudentStatsDtoList(studentStatsDtoList);
        return classStatsDto;
    }


}

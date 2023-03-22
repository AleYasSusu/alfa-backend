package ages.alfa.service.impl;

import ages.alfa.dto.StudentAnswerRequest;
import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Alternative;
import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.StudentAnswer;
import ages.alfa.repository.ActivityRepository;
import ages.alfa.repository.AlternativeRepository;
import ages.alfa.repository.StudentAnswerRepository;
import ages.alfa.repository.StudentRepository;
import ages.alfa.service.StudentAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentAnswerServiceImpl implements StudentAnswerService {

    private final StudentRepository studentRepository;
    private final ActivityRepository activityRepository;
    private final AlternativeRepository alternativeRepository;
    private final StudentAnswerRepository studentAnswerRepository;

    @Override
    public StudentAnswer save(final StudentAnswerRequest request) {

        final Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final Alternative alternative = alternativeRepository.findById(request.getAlternativeId())
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final StudentAnswer studentAnswer = StudentAnswer.builder()
                .student(student)
                .activity(activity)
                .alternative(alternative)
                .correctAnswer(request.getCorrectAnswer())
                .build();

        return studentAnswerRepository.save(studentAnswer);
    }

    public StudentAnswer findById(final Long studentId, final Long activityId) {

        final Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final StudentAnswer studentAnswer = studentAnswerRepository.findByStudentAndActivity(student, activity)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return studentAnswer;
    }
}

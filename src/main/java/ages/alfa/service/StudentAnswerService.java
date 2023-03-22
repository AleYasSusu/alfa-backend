package ages.alfa.service;

import ages.alfa.dto.StudentAnswerRequest;
import ages.alfa.model.entity.StudentAnswer;

public interface StudentAnswerService {


    StudentAnswer save(StudentAnswerRequest request);

    StudentAnswer findById(Long studentAnswerId, Long activityId);
}

package ages.alfa.service.impl;

import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Alternative;
import ages.alfa.repository.ActivityRepository;
import ages.alfa.repository.AlternativeRepository;
import ages.alfa.service.AlternativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AlternativeServiceImpl implements AlternativeService {

    private final AlternativeRepository alternativeRepository;
    private final ActivityRepository activityRepository;

    @Override
    public List<Alternative> findByActivityId(final Long activityId) {
        final Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return alternativeRepository.findAllByActivity(activity);
    }
}

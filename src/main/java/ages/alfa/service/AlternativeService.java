package ages.alfa.service;

import ages.alfa.model.entity.Alternative;

import java.util.List;

public interface AlternativeService {

    List<Alternative> findByActivityId(Long activityId);
}

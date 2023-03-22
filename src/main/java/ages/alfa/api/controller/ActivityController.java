package ages.alfa.api.controller;

import ages.alfa.model.entity.Activity;
import ages.alfa.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping()
    public ResponseEntity<List<Activity>> findByModuleId(@RequestParam("moduleId") final Long moduleId) {
        return ResponseEntity.ok(activityService.findByModuleId(moduleId));
    }

}

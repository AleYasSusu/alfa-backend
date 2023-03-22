package ages.alfa.api.controller;

import ages.alfa.model.entity.Alternative;
import ages.alfa.service.AlternativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/alternative")
@RequiredArgsConstructor
public class AlternativeController {

    private final AlternativeService alternativeService;

    @GetMapping
    public ResponseEntity<List<Alternative>> findByActivityId(@RequestParam("activityId") final Long activityId) {
        return ResponseEntity.ok(alternativeService.findByActivityId(activityId));
    }
}

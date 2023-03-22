package ages.alfa.api.controller;

import ages.alfa.dto.ModuleDto;
import ages.alfa.model.entity.Module;
import ages.alfa.service.ModuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/module")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @SneakyThrows
    @PostMapping("/upload")
    public ResponseEntity<Module> uploadFile(@RequestParam("file") final MultipartFile file) {
        final String content = new String(file.getBytes());
        final ModuleDto moduleDto = new ObjectMapper().readValue(content, ModuleDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.save(moduleDto));
    }

    @GetMapping
    public ResponseEntity<List<Module>> findModulesByClassId(@RequestParam("classId") final Long classId) {
        return ResponseEntity.ok(moduleService.findByClassId(classId));
    }
}

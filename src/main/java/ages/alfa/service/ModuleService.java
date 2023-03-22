package ages.alfa.service;

import ages.alfa.dto.ModuleDto;
import ages.alfa.model.entity.Module;

import java.util.List;

public interface ModuleService {

    List<Module> findByClassId(Long classId);

    Module save(ModuleDto moduleDto);
}

package ages.alfa.repository;

import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findAllByClassz(final Class classz);

}

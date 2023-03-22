package ages.alfa.repository;

import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

    List<Alternative> findAllByActivity(final Activity activity);
}

package market.repository;

import market.model.SizeName;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SizeNameRepository extends CrudRepository<SizeName, Long> {

    List<SizeName> findAll();

    SizeName getSizeNameByName(String name);

    SizeName getById(Long id);

    boolean existsByName(String name);

}

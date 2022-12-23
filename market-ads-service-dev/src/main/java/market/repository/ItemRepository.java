package market.repository;

import market.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Long> {
     List<Item> findAll();
     Item getById (Long Id);
}

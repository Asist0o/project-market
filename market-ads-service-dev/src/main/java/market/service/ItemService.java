package market.service;

import market.model.Item;

import java.util.List;

public interface ItemService {

    void save(Item item);
    void deleteById(Long id);
    Item findById(Long id);
    List<Item> findAll();
}

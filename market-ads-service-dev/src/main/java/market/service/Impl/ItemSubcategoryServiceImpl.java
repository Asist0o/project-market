package market.service.Impl;

import market.model.ItemSubcategory;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import market.repository.ItemSubcategoryRepository;
import market.service.ItemSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemSubcategoryServiceImpl implements ItemSubcategoryService {

    private final ItemSubcategoryRepository itemSubcategoryRepository;

    @Autowired
    public ItemSubcategoryServiceImpl(ItemSubcategoryRepository itemSubcategoryRepository) {
        this.itemSubcategoryRepository = itemSubcategoryRepository;
    }

    @Override
    public void save(ItemSubcategory subcategory) {
        itemSubcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteById(Long id) {
        itemSubcategoryRepository.deleteById(id);
    }

    @Override
    public ItemSubcategory getById(Long id) {
        return itemSubcategoryRepository.getById(id);
    }

    @Override
    public ItemSubcategory findByGenderTypeAndItemCategory(GenderType genderType, ItemCategoryName itemCategoryName) {
        return itemSubcategoryRepository.findByGenderTypeAndItemCategory(genderType, itemCategoryName);
    }

    @Override
    public List<ItemSubcategory> findAll() {
        return itemSubcategoryRepository.findAll();
    }
}

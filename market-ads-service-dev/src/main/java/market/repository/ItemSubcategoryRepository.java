package market.repository;

import market.model.ItemSubcategory;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemSubcategoryRepository extends CrudRepository<ItemSubcategory, Long> {
    @Query("""
            select subcategory
            from ItemSubcategory subcategory
            where subcategory.genderType =: genderType
            and subcategory.itemCategoryName =: itemCategoryName
               """)
    ItemSubcategory findByGenderTypeAndItemCategory(GenderType genderType, ItemCategoryName itemCategoryName);

    ItemSubcategory getById(Long id);

    List<ItemSubcategory> findAll();

}

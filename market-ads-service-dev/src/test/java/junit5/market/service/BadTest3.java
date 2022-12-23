package junit5.market.service;

import market.AdsStarter;
import market.model.Item;
import market.model.ItemSubcategory;
import market.model.SizeName;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import market.model.enums.ItemCondition;
import market.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdsStarter.class})
@Rollback(value = false)
public class BadTest3 {

    @Autowired
    ItemService itemService;

    @Test
    public void add(){
        SizeName sizeName = new SizeName("xxl");
        ItemSubcategory itemSubcategory = new ItemSubcategory(
                1L,
                "Кеды",
                ItemCategoryName.SHOES,
                GenderType.FEMALE,
                null
        );
        Item item = new Item(
                "Converse",
                "1",
                2L,
                ItemCondition.NEW_ITEM_WITHOUT_TAG,
                itemSubcategory,
                sizeName
        );
        itemService.save(item);

    }
}

package junit5.market.service;

import market.AdsStarter;
import market.model.Item;
import market.model.ItemSubcategory;
import market.model.SizeName;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import market.model.enums.ItemCondition;
import market.service.ItemService;
import market.service.ItemSubcategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdsStarter.class})
public class ItemSubcategoryServiceTest {

    @Autowired
    ItemSubcategoryService itemSubcategoryService;

    @Autowired
    ItemService itemService;



    @Test
    public void add2(){
        SizeName sizeName1 = new SizeName("sizename111");
        SizeName sizeName2 = new SizeName("sizename222");
        SizeName sizeName3 = new SizeName("sizename333");
        SizeName sizeName4 = new SizeName("sizename444");

        Set<SizeName> sizeNameSet = new HashSet<>();
        sizeNameSet.add(sizeName1);
        sizeNameSet.add(sizeName2);
        sizeNameSet.add(sizeName3);
        sizeNameSet.add(sizeName4);



//        ItemSubcategory itemSubcategory = new ItemSubcategory();
//        itemSubcategory.setSubcategoryName("subcat1");
//        itemSubcategory.setGenderType(GenderType.FEMALE);
//        itemSubcategory.setItemCategory(ItemCategoryName.TOP);
//        itemSubcategory.setSizeNameSet(sizeNameSet);
//
//        Item item1 = new Item("b1", "m1", 1L, ItemCondition.NEW_ITEM_WITH_TAG, sizeName1);
//        item1.setItemSubcategory(itemSubcategory);
//        Item item2 = new Item("b1", "m1", 1L, ItemCondition.HAS_DEFECTS, sizeName2);
//        item2.setItemSubcategory(itemSubcategory);
//
//        Set<Item> itemSet = new HashSet<>();
//        itemSet.add(item1);
//        itemSet.add(item2);
//
//        itemSubcategory.setItemSet(itemSet);
//
//        itemSubcategoryService.save(itemSubcategory);


    }
}

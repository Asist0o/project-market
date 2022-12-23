package junit5.market.service;

import market.AdsStarter;
import market.model.ItemSubcategory;
import market.model.SizeName;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import market.service.ItemSubcategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

//@DataJpaTest
//
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(value = ItemSubcategoryServiceImpl.class)
//@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdsStarter.class})
@Rollback(value = false)
public class BadTest1 {

//    @Autowired
//    TestEntityManager testEntityManager;

    @Autowired
    ItemSubcategoryService itemSubcategoryService;

    @Test
    public void add(){
        SizeName sizeName1 = new SizeName("sizename111");
        SizeName sizeName2 = new SizeName("sizename222");
        SizeName sizeName3 = new SizeName("sizename333");
        SizeName sizeName4 = new SizeName("sizename444");

        Set<SizeName> sizeNameSet = new HashSet<>();
        sizeNameSet.add(sizeName1);
        sizeNameSet.add(sizeName2);
        sizeNameSet.add(sizeName3);
        sizeNameSet.add(sizeName4);

        ItemSubcategory itemSubcategory = new ItemSubcategory(
                "Кеды",
                ItemCategoryName.SHOES,
                GenderType.MALE,
                sizeNameSet
        );

        itemSubcategoryService.save(itemSubcategory);
    }
}

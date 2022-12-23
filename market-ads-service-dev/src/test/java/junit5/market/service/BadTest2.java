package junit5.market.service;

import market.AdsStarter;
import market.model.Item;
import market.model.ItemSubcategory;
import market.model.SizeName;
import market.model.enums.ItemCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdsStarter.class})
public class BadTest2 {

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void add(){
        ItemSubcategory itemSubcategory = testEntityManager.find(ItemSubcategory.class, 1L);
        System.out.println(itemSubcategory.getSubcategoryName());
        SizeName sizeName = testEntityManager.find(SizeName.class, 1L);
        System.out.println(sizeName.getName());
        Item item = new Item(
                "Nike",
                "X1",
                1000L,
                ItemCondition.NEW_ITEM_WITHOUT_TAG,
                itemSubcategory,
                sizeName
        );

        testEntityManager.persist(item);
    }
}

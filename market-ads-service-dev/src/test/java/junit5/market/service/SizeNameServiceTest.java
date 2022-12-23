package junit5.market.service;

import market.AdsStarter;
import market.model.SizeName;
import market.service.SizeNameServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdsStarter.class})
public class SizeNameServiceTest {

    @Autowired
    SizeNameServices sizeNameServices;

    @Test
    public void add(){
        SizeName sizeName = new SizeName("1 размер");
        sizeNameServices.save(sizeName);
    }
}

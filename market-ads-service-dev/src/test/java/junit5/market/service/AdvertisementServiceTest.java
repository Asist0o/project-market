package junit5.market.service;

import market.AdsStarter;
import market.model.Advertisement;
import market.service.AdvertisementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AdsStarter.class})
public class AdvertisementServiceTest {

    @Autowired
    AdvertisementService advertisementService;

    @Test
    public void add(){
//        List<String> pictures = new ArrayList<>();
//        pictures.add("Pic 1");
//        pictures.add("Pic 2");
//        Set<Long> likes = new HashSet<>();
//        likes.add(1L);
//        likes.add(2L);
//
//        Advertisement advertisement = new Advertisement();
//
//        advertisement.setDescription("Ads 2");
//        advertisement.setLikes(likes);
//        advertisement.setCreatedBy(1L);
//
//        advertisementService.add(advertisement);
//        System.out.println(advertisement);
    }

}

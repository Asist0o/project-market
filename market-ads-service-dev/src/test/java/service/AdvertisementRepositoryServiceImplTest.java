package service;

import market.AdsStarter;
import market.dto.AdsDto;
import market.dto.PageDto;
import market.service.AdvertisementRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {AdsStarter.class})
@ActiveProfiles("test")
public class AdvertisementRepositoryServiceImplTest {

    private final AdvertisementRepositoryService advertisementRepositoryService;

    @Autowired
    public AdvertisementRepositoryServiceImplTest(AdvertisementRepositoryService advertisementRepositoryService) {
        this.advertisementRepositoryService = advertisementRepositoryService;
    }

    @Test
    @Transactional
    public void testSearchByDescription() {
        Integer currentPage = 0;
        Integer countOnPage = 4;
        String searchText = "Техника";

        PageDto<AdsDto> pageDto = advertisementRepositoryService.getPageDtoWithSortedAdvertisementByImportant(currentPage, countOnPage, searchText);
        assertNotNull(pageDto, "получен Null");
        assertTrue(pageDto.getTotalEntitiesCount() <= countOnPage, "Получены лишние объекты");
        List<AdsDto> adsDtoList = pageDto.getEntities();
        for (AdsDto adsDto : adsDtoList) {
            assertTrue(adsDto.getDescription().toLowerCase().contains(searchText.toLowerCase()), "Полученные объекты не содержат поисковые выражения");
        }
    }

    @Test
    @Transactional
    public void testPaginationWithEmptySearch() {
        int currentPage = 0;
        int countOnPage = 4;
        String searchText = "";

        PageDto<AdsDto> pageDto = advertisementRepositoryService.getPageDtoWithSortedAdvertisementByImportant(currentPage, countOnPage, searchText);
        assertTrue(pageDto.getTotalEntitiesCount() >= countOnPage, "Недостаточно объектов в базе данных ");

        assertEquals(countOnPage, pageDto.getEntities().size(), "Не получено ожидаемое количество элементов на странице");
    }


}


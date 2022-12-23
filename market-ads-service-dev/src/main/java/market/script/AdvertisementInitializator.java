package market.script;

import market.dto.AdvertisementDto;
import market.model.Item;
import market.model.ItemSubcategory;
import market.model.SizeName;
import market.model.enums.ApprovedStatus;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import market.model.enums.ItemCondition;
import market.service.AdvertisementDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class AdvertisementInitializator {

    AdvertisementDtoService advertisementDtoService;

    @Autowired
    public AdvertisementInitializator(AdvertisementDtoService advertisementDtoService) {
        this.advertisementDtoService = advertisementDtoService;
    }

//    @PostConstruct
//    public void createMockAdvertisements() {
//        SizeName sizeName1 = new SizeName("36 - F");
//        SizeName sizeName2 = new SizeName("43 - M");
//        SizeName sizeName3 = new SizeName("ONESI");
//        SizeName sizeName4 = new SizeName("60 см");
//        SizeName sizeName5 = new SizeName("36 мм");
//
//        AdvertisementDto a1 = new AdvertisementDto(1L, "Almost new sneakers for sport",
//                new HashSet<>(Arrays.asList(1L, 2L)),
//                new Item(1L, "Nike", "sport", 100L, ItemCondition.WORN_ONCE,
//                        new ItemSubcategory(
//                                1L, "sport", ItemCategoryName.SHOES,
//                                GenderType.FEMALE, new HashSet<>(Arrays.asList(sizeName1))
//                        ), sizeName1),
//                ApprovedStatus.APPROVED);
//
//        AdvertisementDto a2 = new AdvertisementDto(2L, "2nd mock Advertisement",
//                new HashSet<>(Arrays.asList(3L, 4L)),
//                new Item(2L, "Adidas", "Classic", 200L, ItemCondition.NEW_ITEM_WITHOUT_TAG,
//                        new ItemSubcategory(
//                                2L, "casual suit", ItemCategoryName.TOP,
//                                GenderType.MALE, new HashSet<>(Arrays.asList(sizeName2))
//                        ), sizeName2),
//                ApprovedStatus.APPROVED);
//
//        AdvertisementDto a3 = new AdvertisementDto(3L, "КОШЕЛЕК ИЗ МАТОВОЙ ЗЕРНИСТОЙ КОЖИ С КОНТРАСТНЫМ ЛОГОТИПОМ",
//                new HashSet<>(Arrays.asList(5L, 6L)),
//                new Item(3L, "Hugo Boss", " BIG BC_4 CC COIN - 50470793", 240L, ItemCondition.HAS_DEFECTS,
//                        new ItemSubcategory(
//                                3L, "men's wallet", ItemCategoryName.ACCESSORIES,
//                                GenderType.MALE, new HashSet<>(Arrays.asList(sizeName3))
//                        ), sizeName3),
//                ApprovedStatus.APPROVED);
//
//        AdvertisementDto a4 = new AdvertisementDto(4L, "РЕМЕНЬ ИЗ ГЛАДКОЙ КОЖИ С МАТОВОЙ ПРЯЖКОЙ",
//                new HashSet<>(Arrays.asList(7L, 8L)),
//                new Item(4L, "Hugo Boss", "JEEKO_SZ40 - 50386229", 50L, ItemCondition.WORN_SEVERAL_TIMES,
//                        new ItemSubcategory(
//                                4L, "belts", ItemCategoryName.ACCESSORIES,
//                                GenderType.MALE, new HashSet<>(Arrays.asList(sizeName4))
//                        ), sizeName4),
//                ApprovedStatus.ON_CHECKING);
//
//        AdvertisementDto a5 = new AdvertisementDto(5L, "Gucci - Часы G-Timeless",
//                new HashSet<>(Arrays.asList(9L, 10L)),
//                new Item(5L, "Gucci", "681758 I8600 9802", 500L, ItemCondition.WORN_SEVERAL_TIMES,
//                        new ItemSubcategory(
//                                5L, "watches", ItemCategoryName.ACCESSORIES,
//                                GenderType.FEMALE, new HashSet<>(Arrays.asList(sizeName5))
//                        ), sizeName5),
//                ApprovedStatus.ON_CHECKING);
//
//        advertisementDtoService.add(a1, 1L);
//        advertisementDtoService.add(a2, 1L);
//        advertisementDtoService.add(a3, 1L);
//        advertisementDtoService.add(a4, 1L);
//        advertisementDtoService.add(a5, 1L);
//    }
}


package market.service;

import market.dto.AdsDto;
import market.dto.PageDto;

public interface AdvertisementRepositoryService {
    PageDto<AdsDto> getPageDtoWithSortedAdvertisementByImportant(Integer currentPage, Integer countOnPage, String search);

    void addAd(AdsDto adsDto);
}

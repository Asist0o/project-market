package market.service.Impl;

import market.converters.AdsConverter;
import market.repository.AdvertisementRepository;
import market.dto.AdsDto;
import market.dto.PageDto;
import market.model.Advertisement;
import market.service.AdvertisementRepositoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementRepositoryServiceImpl implements AdvertisementRepositoryService {

    private final AdvertisementRepository advertisementRepository;
    private final AdsConverter adsConverter;

    public AdvertisementRepositoryServiceImpl(AdvertisementRepository advertisementRepository, AdsConverter adsConverter) {
        this.advertisementRepository = advertisementRepository;
        this.adsConverter = adsConverter;
    }

    @Override
    public PageDto<AdsDto> getPageDtoWithSortedAdvertisementByImportant(Integer currentPage, Integer countOnPage, String searchText) {
        String modifyingSearch = modifyingSearchForSqlQuery(searchText);
        Pageable pageable = PageRequest.of(currentPage, countOnPage, Sort.by("important", "importantDateFrom", "createdBy").descending());
        Page<Advertisement> pageSortedByImportant = advertisementRepository.findAllByDescriptionLikeIgnoreCase(pageable, modifyingSearch);
        List<Advertisement> ads = pageSortedByImportant.getContent();
        return new PageDto<>(pageSortedByImportant.getTotalElements(), currentPage + 1, pageSortedByImportant.getTotalPages(), ads.stream().
                map(adsConverter::convertToDto).collect(Collectors.toList()));
    }

    private String modifyingSearchForSqlQuery(String search) {
        search = "%" + search + "%";
        return search;
    }

    @Override
    public void addAd(AdsDto adsDto) {
        advertisementRepository.save(adsConverter.convertToEntity(adsDto));
    }
}

package market.service;

import market.dto.AdvertisementDto;

public interface AdvertisementDtoService {
    void add(AdvertisementDto advertisementDto, Long createdBy);
    void update(AdvertisementDto advertisementDto, Long createdBy);
    void delete(Long id);
}

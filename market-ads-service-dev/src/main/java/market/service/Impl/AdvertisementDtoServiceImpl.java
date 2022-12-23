package market.service.Impl;

import market.dto.AdvInfoForPostDto;
import market.dto.AdvertisementDto;
import market.feign.SocialMediaFeignClient;
import market.model.Advertisement;
import market.service.AdvertisementDtoService;
import market.service.AdvertisementService;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementDtoServiceImpl implements AdvertisementDtoService {

    private final AdvertisementService advertisementService;
    private final SocialMediaFeignClient socialMediaFeignClient;

    public AdvertisementDtoServiceImpl(AdvertisementService advertisementService, SocialMediaFeignClient socialMediaFeignClient) {
        this.advertisementService = advertisementService;
        this.socialMediaFeignClient = socialMediaFeignClient;
    }

    @Override
    public void add(AdvertisementDto advertisementDto, Long createdBy) {
        Advertisement advertisement = new Advertisement();
        advertisement.setDescription(advertisementDto.description());
        advertisement.setCreatedBy(createdBy);
        advertisement.setPictures(advertisementDto.pictures());
        advertisement.setItem(advertisementDto.item());
        advertisementService.save(advertisement);

        AdvInfoForPostDto advInfoForPostDto = AdvInfoForPostDto.builder()
                .idAdvertisement(advertisementDto.id())
                .description(advertisementDto.description())
                .idImages(advertisementDto.pictures())
                .build();

        socialMediaFeignClient.getInfoForPost(advInfoForPostDto);
    }

    @Override
    public void update(AdvertisementDto advertisementDto, Long createdBy) {
        Advertisement advertisement = new Advertisement();
        advertisement.setId(advertisementDto.id());
        advertisement.setDescription(advertisementDto.description());
        advertisement.setCreatedBy(createdBy);
        advertisement.setPictures(advertisementDto.pictures());
        advertisement.setItem(advertisementDto.item());
        advertisement.getItem().setId(advertisement.getId());
        advertisement.setIsApproved(advertisementDto.isApproved());
        advertisementService.save(advertisement);
    }

    @Override
    public void delete(Long id) {
        advertisementService.deleteById(id);
    }
}

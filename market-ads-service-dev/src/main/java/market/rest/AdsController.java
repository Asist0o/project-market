package market.rest;

import market.dto.AdsDto;
import market.dto.PageDto;
import market.dto.response.Response;
import market.dto.response.SuccessResponse;
import market.service.AdvertisementRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.DefaultValue;


// TODO
// перенести на дату
@RestController
@RequestMapping("/api/ads")
public class AdsController {

    private final AdvertisementRepositoryService advertisementRepositoryService;

    @Value("${countOnPage}")
    private int countOnPage;

    @Autowired
    public AdsController(AdvertisementRepositoryService advertisementRepositoryService) {
        this.advertisementRepositoryService = advertisementRepositoryService;
    }


//    @GetMapping("/pageInteresting")
//    public PageDto<Advertisement> getInterestingAdvertisementPage(
//            @RequestParam int currentPage
//    ) {
//        return pageDtoService.getInterestingPageDto(
//                currentPage,
//                this.countOnPage
//        );
//    }
//
//    @GetMapping("/int")
//    public Response<?> makeAdvertisementInterestingById(@RequestParam Long id){
//        advertisementService.getById(id).setInteresting(true);
//        return Response.success().status(200).build();
//    }
//
//
//    @PutMapping
//    public Response<?> putAdvertisement(@RequestBody @Valid AdvertisementDto advertisementDto) {
//        advertisementDtoService.update(advertisementDto);
//
//        return Response.success().status(200).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public Response<?> deleteAdvertisement(@PathVariable long id){
//        advertisementDtoService.delete(id);
//
//        return Response.success().status(200).build();
//    }

    @GetMapping
    public SuccessResponse<PageDto<AdsDto>> getPage(@RequestParam Integer currentPage, @DefaultValue("") String search) {
        return Response.success(advertisementRepositoryService.getPageDtoWithSortedAdvertisementByImportant(currentPage, countOnPage, search));
    }

    @PostMapping
    public Response<?> addAd(@RequestBody AdsDto adsDto) {
        advertisementRepositoryService.addAd(adsDto);
        return Response.success().status(200).build();
    }

}

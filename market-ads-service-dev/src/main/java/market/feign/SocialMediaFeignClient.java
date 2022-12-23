package market.feign;

import market.dto.AdvInfoForPostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("market-social-media")
public interface SocialMediaFeignClient {

    @PostMapping("/api/social-media/push-info")
    ResponseEntity<String> getInfoForPost(AdvInfoForPostDto advInfoForPostDto);

}

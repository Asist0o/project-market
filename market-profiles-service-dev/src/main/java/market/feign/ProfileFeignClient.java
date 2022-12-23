package market.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "profiles-service")
public interface ProfileFeignClient {
    @PostMapping("/email/birthday/{user-email}/{username}")
    public void sendBirthdayMessage(@PathVariable("user-email") String email, @PathVariable String username);
}
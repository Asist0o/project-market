package market.response.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "email-service", url = "http://localhost:8084")
public interface EmailFeignClient {
}

package market.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ads-service", url = "http://localhost:8081")
public interface AdsFeignClient {
}

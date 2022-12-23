package market.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "files-storage-service", url = "http://localhost:8088")
public interface StorageFeignClient {
}

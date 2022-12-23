package market.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class ServiceDescriptionUpdater {

    private static final Logger logger = LoggerFactory.getLogger(ServiceDescriptionUpdater.class);
    private static final String DEFAULT_SWAGGER_URL = "/v3/api-docs";
    private static final String KEY_SWAGGER_URL = "/v3/api-docs";

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final ServiceDefinitionsContext serviceDefinitionsContext;

    @Scheduled(fixedDelayString = "${swagger.config.refreshRate}")
    public void refreshSwaggerConfigurations() {
        discoveryClient.getServices().forEach(serviceId -> {
            List<ServiceInstance> instanceList = discoveryClient.getInstances(serviceId);
            if (instanceList.isEmpty()) {
                logger.info("No instances available for service : {} ", serviceId);
            } else {
                ServiceInstance instance = instanceList.get(0);
                Optional<Object> jsonData = getSwaggerDefinitionForApi(serviceId, getSwaggerUrl(instance));
                if (jsonData.isPresent()) {
                    serviceDefinitionsContext.addServiceDefinition(serviceId, getJson(jsonData.get()));
                } else {
                    logger.error("Skipping service id : {} Error : Could not get Swagger definition from API ", serviceId);
                }
            }
        });
    }

    private String getSwaggerUrl(ServiceInstance instance) {
        String swaggerURL = instance.getMetadata().get(KEY_SWAGGER_URL);
        return swaggerURL != null ? instance.getUri() + swaggerURL : instance.getUri() + DEFAULT_SWAGGER_URL;
    }

    private Optional<Object> getSwaggerDefinitionForApi(String serviceId, String swaggerURL) {
        logger.debug("Accessing the SwaggerDefinition JSON for Service : {} : URL : {} ", serviceId, swaggerURL);
        try {
            return Optional.ofNullable(restTemplate.getForObject(swaggerURL, Object.class));
        } catch (RestClientException ex) {
            logger.error("Error while getting service definition for service : {} Error : {} ", serviceId, ex.getMessage());
            return Optional.empty();
        }
    }

    private String getJson(Object jsonObject) {
        try {
            return new ObjectMapper().writeValueAsString(jsonObject);
        } catch (JsonProcessingException ex) {
            logger.error("Error : {} ", ex.getMessage());
            return "";
        }
    }
}
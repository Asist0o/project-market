package market.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ServiceDefinitionsContext {

    private final ConcurrentHashMap<String, String> serviceDescriptions;

    // don't use @AllArgsConstructor
    public ServiceDefinitionsContext() {
        this.serviceDescriptions = new ConcurrentHashMap<>();
    }

    public void addServiceDefinition(String serviceId, String serviceDescription) {
        serviceDescriptions.put(serviceId, serviceDescription);
    }

    public String getSwaggerDefinition(String serviceId) {
        return this.serviceDescriptions.get(serviceId);
    }

    public List<SwaggerResource> getSwaggerDefinitions() {
        return serviceDescriptions.keySet().stream().map(serviceName -> {
            SwaggerResource resource = new SwaggerResource();
            resource.setLocation("/service/" + serviceName);
            resource.setName(serviceName);
            resource.setSwaggerVersion("3.0");
            return resource;
        }).toList();
    }
}
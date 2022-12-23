package market.controller;

import lombok.AllArgsConstructor;
import market.config.ServiceDefinitionsContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ServiceDefinitionController {

    private final ServiceDefinitionsContext serviceDefinitionsContext;

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/service/{serviceName}")
    public String getServiceDefinition(@PathVariable("serviceName") String serviceName) {
        return serviceDefinitionsContext.getSwaggerDefinition(serviceName);
    }
}
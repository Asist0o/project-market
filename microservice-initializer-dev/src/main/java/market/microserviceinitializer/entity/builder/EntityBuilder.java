package market.microserviceinitializer.entity.builder;

import java.util.List;

public interface EntityBuilder {
    void buildEntity(String projectName, List<String> entityName);
}

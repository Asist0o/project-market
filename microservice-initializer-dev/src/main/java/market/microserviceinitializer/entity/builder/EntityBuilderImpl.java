package market.microserviceinitializer.entity.builder;

import market.microserviceinitializer.entity.util.EntityStructureInitializer;
import market.microserviceinitializer.entity.util.EntityInitializer;

import java.util.List;

@org.springframework.stereotype.Service
public class EntityBuilderImpl implements EntityBuilder {

    private final EntityStructureInitializer entityStructure;
    private final EntityInitializer entityInitializer;

    public EntityBuilderImpl(EntityStructureInitializer entityStructure,
                             EntityInitializer entityInitializer) {
        this.entityStructure = entityStructure;
        this.entityInitializer = entityInitializer;
    }

    public void buildEntity(String projectName, List<String> entityName) {
        entityStructure.createEntityStructure(projectName);
        entityInitializer.createEntity(projectName, entityName);
    }
}

package market.microserviceinitializer.pom.builder;

import lombok.Data;
import market.microserviceinitializer.pom.util.PomFileBuilder;
import market.microserviceinitializer.pom.util.PomFileCreator;
import org.springframework.stereotype.Service;

@Service
@Data
public class PomBuilderImpl implements PomBuilder {

    private final PomFileBuilder builder;
    private final PomFileCreator creator;

    public void build(String projectGroupId, String projectArtifactId, String projectVersion, String dependencyGroupId, String dependencyArtifactId, String dependencyVersion) {
        creator.Create(builder.buildPomContent(projectGroupId, projectArtifactId, projectVersion, dependencyGroupId, dependencyArtifactId, dependencyVersion));
    }

}

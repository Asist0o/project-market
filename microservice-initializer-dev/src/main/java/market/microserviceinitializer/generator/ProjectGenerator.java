package market.microserviceinitializer.generator;

import java.util.List;

public interface ProjectGenerator {

    void generate (String projectName, List<String> entityName, String projectGroupId, String projectArtifactId, String projectVersion, String dependencyGroupId, String dependencyArtifactId, String dependencyVersion);
}

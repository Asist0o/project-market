package market.microserviceinitializer.generator;

import market.microserviceinitializer.entity.builder.EntityBuilder;
import market.microserviceinitializer.pom.builder.PomBuilder;
import market.microserviceinitializer.structure.builder.ProjectStructureBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectGeneratorImpl implements ProjectGenerator {

    private final EntityBuilder entityBuilder;
    private final PomBuilder pomBuilder;
    private final ProjectStructureBuilder projectStructureBuilder;

    public ProjectGeneratorImpl(EntityBuilder entityBuilder, PomBuilder pomBuilder, ProjectStructureBuilder projectStructureBuilder) {
        this.entityBuilder = entityBuilder;
        this.pomBuilder = pomBuilder;
        this.projectStructureBuilder = projectStructureBuilder;
    }

    public void generate (String projectName, List<String> entityName,String projectGroupId, String projectArtifactId, String projectVersion, String dependencyGroupId, String dependencyArtifactId, String dependencyVersion){
        entityBuilder.buildEntity(projectName,entityName);
        pomBuilder.build(projectGroupId,projectArtifactId,projectVersion,dependencyGroupId,dependencyArtifactId,dependencyVersion);
        projectStructureBuilder.build(projectName);

    }
}

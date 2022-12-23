package market.microserviceinitializer.pom.builder;

public interface PomBuilder {

    void build(String projectGroupId, String projectArtifactId, String projectVersion, String dependencyGroupId, String dependencyArtifactId, String dependencyVersion);

}

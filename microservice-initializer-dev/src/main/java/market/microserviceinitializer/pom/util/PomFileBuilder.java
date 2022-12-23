package market.microserviceinitializer.pom.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PomFileBuilder {

    private final String baseStructure =
            """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
                        <modelVersion>4.0.0</modelVersion>
                            <parent>
                                <groupId>org.springframework.boot</groupId>
                                <artifactId>spring-boot-starter-parent</artifactId>
                                <version>3.0.0</version>
                                <relativePath/> <!-- lookup parent from repository -->
                            </parent>
                            %s
                            %s
                    </project>""";


    private final DependencyGenerator dependencyConstructor;
    private final ProjectInfoGenerator projectInfo;

    public String buildPomContent(String projectGroupId, String projectArtifactId, String projectVersion, String dependencyGroupId, String dependencyArtifactId, String dependencyVersion) {

        String projectInformation = projectInfo.fillProjectInfo(projectGroupId, projectArtifactId, projectVersion);

        String dependencies = """
                <dependencies>
                        %s
                </dependencies>""".formatted(dependencyConstructor.generateDependency(dependencyGroupId, dependencyArtifactId, dependencyVersion));

        return baseStructure.formatted(projectInformation, dependencies);

    }



}

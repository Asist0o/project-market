package market.microserviceinitializer.pom.util;

import org.springframework.stereotype.Component;

@Component
public class ProjectInfoGenerator {

    public String fillProjectInfo(String groupId, String artifactId, String version) {
        String projectInfoTemplate = """
                    <groupId>%s</groupId>
                    <artifactId>%s</artifactId>
                    <version>%s</version>
                """;
        return projectInfoTemplate.formatted(groupId, artifactId, version);
    }



}

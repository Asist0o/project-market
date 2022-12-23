package market.microserviceinitializer.pom.util;

import org.springframework.stereotype.Component;

@Component
public class DependencyGenerator {

    public String generateDependency(String groupId, String artifactId, String version) {
        return """
                <dependency>
                    <groupId>%s</groupId>
                    <artifactId>%s</artifactId>
                    <version>%s</version>
                </dependency>
                """.formatted(groupId, artifactId, version);
    }

}

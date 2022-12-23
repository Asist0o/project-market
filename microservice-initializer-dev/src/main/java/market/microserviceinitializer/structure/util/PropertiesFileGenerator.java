package market.microserviceinitializer.structure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Component
public class PropertiesFileGenerator {
    public void placeBaseFiles(String projectName) {
        Path yamlFilePath = Path.of("../" + projectName + "/src/main/resources/application.yaml");
        Path applicationJavaFilePath = Path.of("../" + projectName + "/src/main/java/com/kata/market/" + projectName + "/" + StringUtils.capitalize(projectName) + "Application.java");
        try {
            if (!Files.exists(yamlFilePath) & !Files.exists(applicationJavaFilePath)) {
                Files.createFile(yamlFilePath);
                Files.createFile(applicationJavaFilePath);
            } else log.error("Files already exist!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

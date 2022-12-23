package market.microserviceinitializer.structure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Component
public class ProjectStructureInitializer {

    public void createBaseFolderStructure(String projectName){
        try {
            if (!Files.exists(Path.of("../" + projectName))) {
                Files.createDirectories(Path.of("../" + projectName + "/src/main/java/com/kata/market/" + projectName));
                Files.createDirectories(Path.of("../" + projectName + "/src/main/resources"));
                Files.createDirectories(Path.of("../" + projectName + "/src/test/java"));
            } else {
                log.error("A project with this name already exists!");
                throw new RuntimeException("A project with this name already exists!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

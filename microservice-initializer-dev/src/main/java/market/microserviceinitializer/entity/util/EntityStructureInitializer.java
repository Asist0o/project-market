package market.microserviceinitializer.entity.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Component
public class EntityStructureInitializer {

    public void createEntityStructure(String projectName) {
        try {
            if (!Files.exists(Path.of("../" + projectName))) {
                Files.createDirectories(Path.of("../" + projectName
                        + "/src/main/java/com/kata/market/" + projectName + "/entity"));
                Files.createDirectories(Path.of("../" + projectName
                        + "/src/main/java/com/kata/market/" + projectName + "/rest"));
                Files.createDirectories(Path.of("../" + projectName
                        + "/src/main/java/com/kata/market/" + projectName + "/service"));
                Files.createDirectories(Path.of("../" + projectName
                        + "/src/main/java/com/kata/market/" + projectName + "/repository"));
            } else {
                log.error("A project with this name already exists!");
                throw new RuntimeException("A project with this name already exists!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

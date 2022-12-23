package market.microserviceinitializer.entity.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Component
public class EntityInitializer {

    public void createEntity(String projectName, List<String> entityName) {
        for (String name : entityName) {
            String structureEntity = "package market." + projectName + ";\n" +
                    "\n" +
                    "import lombok.Data;\n" +
                    "\n" +
                    "@Data\n" +
                    "public class" + name + "{\n" +
                    "\n" +
                    "}";

            Path entityFile = Path.of("../" + projectName
                    + "/src/main/java/com/kata/market/" + projectName + "/entity/" + name + ".java");
            createClass(entityFile, structureEntity);
        }
    }

    private void createClass(Path entityFile, String structureEntity) {
        try {
            if (!Files.exists(entityFile)) {
                Files.createFile(entityFile);
                Files.write(entityFile, structureEntity.getBytes());
            } else log.error("Files already exist!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

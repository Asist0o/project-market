package market.microserviceinitializer;

import market.microserviceinitializer.pom.util.PomFileCreator;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PomFileCreatorTest {


    @Test
    void fileIsCreatedCheck() {

        String testPath = "./test.xml";
        PomFileCreator creator = PomFileCreator.PomFileCreatorBuilder.aPomFileCreator().withPath(testPath).build();
        creator.Create("Test content");
        assertTrue(Files.exists(Path.of(testPath)));
    }

}

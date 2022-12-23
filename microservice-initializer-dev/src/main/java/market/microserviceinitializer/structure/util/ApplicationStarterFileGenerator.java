package market.microserviceinitializer.structure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Component
public class ApplicationStarterFileGenerator {
    private final String baseStructure = """
            package %s;
                        
            import org.springframework.boot.SpringApplication;
            import org.springframework.boot.autoconfigure.SpringBootApplication;
                        
            @SpringBootApplication
            public class %sApplication {
                        
            	public static void main(String[] args) {
            		SpringApplication.run(%sApplication.class, args);
            	}
                        
            }
            """;

    public void build(String projectName) {
        String capitalizedProjectName = StringUtils.capitalize(projectName);
        Path applicationJavaFilePath = Path.of("../" + projectName + "/src/main/java/com/kata/market/" + projectName + "/" + capitalizedProjectName + "Application.java");
        try {

                Files.write(applicationJavaFilePath,
                        baseStructure.formatted("com.kata.market." + projectName, capitalizedProjectName, capitalizedProjectName)
                                .getBytes());
                log.info("Application.java is filled");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

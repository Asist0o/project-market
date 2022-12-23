package market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @see "readme.md"
 */
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class DocumentationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentationServiceApplication.class, args);
    }
}

package market.microserviceinitializer.pom.util;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@Setter
@Slf4j
public class PomFileCreator {
    @Value("${pom.file-path}")
    private String path;

    public void Create(String pomContent) {

        try {
            Files.write(Path.of(path), pomContent.getBytes());
            log.info("Pom.xml is created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static final class PomFileCreatorBuilder {
        private String path;

        private PomFileCreatorBuilder() {
        }

        public static PomFileCreatorBuilder aPomFileCreator() {
            return new PomFileCreatorBuilder();
        }

        public PomFileCreatorBuilder withPath(String path) {
            this.path = path;
            return this;
        }

        public PomFileCreator build() {
            PomFileCreator pomFileCreator = new PomFileCreator();
            pomFileCreator.setPath(path);
            return pomFileCreator;
        }
    }
}

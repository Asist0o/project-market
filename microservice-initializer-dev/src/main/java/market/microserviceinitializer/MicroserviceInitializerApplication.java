package market.microserviceinitializer;

import market.microserviceinitializer.pom.builder.PomBuilderImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceInitializerApplication implements CommandLineRunner {
	private final PomBuilderImpl service;

	public MicroserviceInitializerApplication(PomBuilderImpl service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceInitializerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		service.build("MyGroup", "MyArtifact", "1-0-0",
				"some-dependency", "dependency-artifact", "1-1-1");
	}
}

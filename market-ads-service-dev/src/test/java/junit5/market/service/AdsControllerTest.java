package junit5.market.service;

import market.AdsStarter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Testcontainers
@SpringBootTest
@ContextConfiguration(classes = {AdsStarter.class}, initializers = {AdsControllerTest.Initializer.class})
@AutoConfigureMockMvc
//@TestPropertySource("classpath:application-dev.yaml")
public class AdsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:12")
            .withUsername("DB_USERNAME")
            .withPassword("DB_PASSWORD")
            .withDatabaseName("tescontainers")
            .withInitScript("create_tables_for_AdsControllerTest.sql");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword(),
                    "spring.liquibase.enabled=false"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    void testPostgreSQLModule() {
        System.out.println(postgreSQLContainer.getJdbcUrl());
        System.out.println(postgreSQLContainer.getDatabaseName());
        System.out.println(postgreSQLContainer.getUsername());
        System.out.println(postgreSQLContainer.getPassword());
    }

    @Test
    void getPageTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ads")
                        .param("currentPage", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalEntitiesCount").value(6))
                .andExpect(jsonPath("$.currentPage").value(1))
                .andExpect(jsonPath("$.entities").isNotEmpty());
    }
}


package market.service;

import com.google.gson.Gson;
import market.EmailStarter;
import market.dto.ProfileCreatedEventDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.internal.matchers.StringContains.containsString;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmailStarter.class})
@DirtiesContext
class MailServiceTest {
    String data;
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson;
    private KafkaConsumerMode consumer;

    @Autowired
    public MailServiceTest(KafkaTemplate<String, String> kafkaTemplate, Gson gson, KafkaConsumerMode consumer) {
        this.kafkaTemplate = kafkaTemplate;
        this.gson = gson;
        this.consumer = consumer;
    }

    @BeforeEach
    void setUp() {
        ProfileCreatedEventDto profileDto = new ProfileCreatedEventDto(1L, "Admin", "Admin", "admin@test.io");
        data = gson.toJson(profileDto);
    }

    @Test
    void sendTestMessage() throws InterruptedException {
        kafkaTemplate.send("test", data);
        boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);
        assertThat(consumer.getPayload(), containsString(data));
    }

    @Test
    void sendProfilesCreatedMessage() {
        kafkaTemplate.send("profiles_created", data);
    }
}
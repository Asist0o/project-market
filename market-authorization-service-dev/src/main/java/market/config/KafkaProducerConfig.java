package market.config;

import market.dto.ProfileDto;
import market.entity.PasswordResetToken;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application-docker.properties")
public class KafkaProducerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Value("${kafka.client-id}")
    private String clientId;

    @Value("${topic.account-name}")
    private String profileTopic;

    @Value("${topic.email-name}")
    private String emailTopic;

    @Value("${topic.reset-password}")
    private String passwordTopic;

    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        return config;
    }

    @Bean
    public ProducerFactory<String, ProfileDto> producerProfileFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ProfileDto> kafkaProfileTemplate() {
        KafkaTemplate<String, ProfileDto> template = new KafkaTemplate<>(producerProfileFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }

    @Bean
    public ProducerFactory<String, PasswordResetToken> producerEmailFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, PasswordResetToken> kafkaEmailTemplate() {
        return new KafkaTemplate<>(producerEmailFactory());
    }

    @Bean
    public NewTopic profileTopic() {
        return TopicBuilder
                .name(profileTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic emailTopic() {
        return TopicBuilder
                .name(emailTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic passwordTopic() {
        return TopicBuilder
                .name(passwordTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}

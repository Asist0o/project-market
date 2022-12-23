package market.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import market.dto.ProfileCreatedEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class KafkaListenerService {
    private static final String topic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private final KafkaService kafkaService;

    @KafkaListener(topics = topic)

    public void consumeMessage(String message) throws JsonProcessingException {
        ProfileCreatedEventDto profileCreatedEventDto = objectMapper.readValue(message, ProfileCreatedEventDto.class);
        kafkaService.persistProfile(profileCreatedEventDto);
    }
}

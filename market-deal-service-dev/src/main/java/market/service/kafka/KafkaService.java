package market.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import market.dto.DealDto;
import market.model.Deal;
import market.repository.DealRepository;
import market.utils.DealConverter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class KafkaService {

    private final DealRepository dealRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(id = "deal", topics = "deal-create", containerFactory = "singleFactory")
    public void consumeMessage(String message) throws JsonProcessingException {
        DealDto dealDto = objectMapper.readValue(message, DealDto.class);
        persistProfile(dealDto);
    }

    public void persistProfile(DealDto dealDto) {
        Deal deal = DealConverter.toEntity(dealDto);
        Deal persistDeal = dealRepository.save(deal);
        log.info("profileCreatedEvent persisted {}", persistDeal);
    }
}

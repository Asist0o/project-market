package market.service.impl;

import lombok.RequiredArgsConstructor;
import market.dto.ProfileDto;
import market.entity.PasswordResetToken;
import market.service.ProducerKafkaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerKafkaServiceImpl implements ProducerKafkaService {

    private final KafkaTemplate<String, ProfileDto> kafkaProfileTemplate;
    private final KafkaTemplate<String, PasswordResetToken> kafkaEmailTemplate;

    @Value("${topic.account-name}")
    private String profileTopic;

    @Value("${topic.email-name}")
    private String emailTopic;

    @Value("${topic.reset-password}")
    private String passwordTopic;

    @Override
    public void send(ProfileDto profileDto) {
        kafkaProfileTemplate.send(profileTopic, profileDto);
        kafkaProfileTemplate.send(emailTopic, profileDto);
    }

    @Override
    public void sendTokenEmail(PasswordResetToken passwordResetToken) {
        kafkaEmailTemplate.send(passwordTopic, passwordResetToken);
    }
}

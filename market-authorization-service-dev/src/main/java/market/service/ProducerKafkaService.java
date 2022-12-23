package market.service;

import market.dto.ProfileDto;
import market.entity.PasswordResetToken;

public interface ProducerKafkaService {

    void send(ProfileDto profileDto);

    void sendTokenEmail(PasswordResetToken passwordResetToken);
}

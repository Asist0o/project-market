package market.service;

import com.google.gson.Gson;
import freemarker.template.TemplateException;
import market.dto.EmailSendEventDto;
import market.dto.ProfileCreatedEventDto;
import market.model.EmailType;
import market.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class ConsumerServiceImpl implements ConsumerService{
    private final Gson gson;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MailService mailService;

    public ConsumerServiceImpl(Gson gson, KafkaTemplate<String, String> kafkaTemplate, MailService mailService) {
        this.gson = gson;
        this.kafkaTemplate = kafkaTemplate;
        this.mailService = mailService;
    }

    /*@KafkaListener(topics = "messages", groupId = "message_group_id")
    public void consume(Message message){
        System.out.println("Consuming the message: " + message);
    }*/

    @KafkaListener(topics="profiles_created")
    public void onProfileCreated(String message) throws TemplateException, MessagingException, IOException {
        ProfileCreatedEventDto profile = gson.fromJson(message, ProfileCreatedEventDto.class);
        mailService.sendRegistrationMessage(profile.getFirstName(), profile.getEmail());
        EmailSendEventDto sendEvent = new EmailSendEventDto(profile.getAccountId(), EmailType.REGISTRATION);

        kafkaTemplate.send("email_success", gson.toJson(sendEvent));
    }
}

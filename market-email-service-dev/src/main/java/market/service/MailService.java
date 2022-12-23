package market.service;

import com.google.gson.Gson;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import market.dto.CompletedOrderEventDTO;
import market.dto.EmailSendEventDto;
import market.dto.MailMessageDto;
import market.dto.ProfileCreatedEventDto;
import market.model.EmailType;
import market.model.MailLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class MailService {
    private final JavaMailSender javaMailSender;
    private final FreeMarkerConfigurer freemarkerConfigurer;

    @Value("${spring.mail.username}")
    private String mailMarket;

    public MailService(JavaMailSender javaMailSender, FreeMarkerConfigurer freemarkerConfigurer, Gson gson, KafkaTemplate<String, String> kafkaTemplate) {
        this.javaMailSender = javaMailSender;
        this.freemarkerConfigurer = freemarkerConfigurer;
    }

    /*public void sender(String emailTo,String subject, String text) { //простое письмо
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailMarket);
        msg.setTo(emailTo);
        msg.setSubject(subject);
        msg.setText(text);
        javaMailSender.send(msg);

    }*/

    public void sendMessageUsingFreemarkerTemplate(MailMessageDto mailMessageDto)
            throws IOException, TemplateException, MessagingException {

        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("username", mailMessageDto.getUsername());

        if (mailMessageDto.getMailLanguages()
                .getLanguage()
                .contains("RU")) {

            Template freemarkerTemplate = freemarkerConfigurer.getConfiguration()
                    .getTemplate("welcome-message-ru.ftl");
            String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, templateModel);

            sendEmailByEmailAndSubjectAndHtmlBody(mailMessageDto.getTo(), mailMessageDto.getSubject(), htmlBody);
        } else {
            Template freemarkerTemplate = freemarkerConfigurer.getConfiguration()
                    .getTemplate("welcome-message-eng.ftl");
            String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, templateModel);

            sendEmailByEmailAndSubjectAndHtmlBody(mailMessageDto.getTo(), mailMessageDto.getSubject(), htmlBody);
        }


    }

    private void sendEmailByEmailAndSubjectAndHtmlBody(String emailto, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(emailto);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        javaMailSender.send(message);
        System.out.println("message sent");
    }

    public void sendBirthdayMessage(String username, String email) throws IOException, TemplateException, MessagingException {
        Map<String, Object> templateModel = new HashMap<>();

        templateModel.put("username", username);

        Template template = freemarkerConfigurer.getConfiguration().getTemplate("birthday-message.ftl");
        String htmlbody = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel);
        String subject = "Birthday";

        sendEmailByEmailAndSubjectAndHtmlBody(email, subject, htmlbody);

    }

    public void sendRegistrationMessage(String name, String email) throws TemplateException, MessagingException, IOException {
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("username", name);
        templateModel.put("email", email);

        Template template = freemarkerConfigurer.getConfiguration().getTemplate("registration-message.ftl");
        String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel);

        sendEmailByEmailAndSubjectAndHtmlBody(email, "Registration completed successfully", htmlBody);

    }

    public void sendSuccessfulOrderMessage(CompletedOrderEventDTO completedOrder) throws TemplateException, MessagingException, IOException {
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("firstName", completedOrder.getFirstName());
        templateModel.put("lastName", completedOrder.getLastName());
        templateModel.put("orderNumber", completedOrder.getOrderNumber());
        templateModel.put("orderDate", completedOrder.getOrderDate());
        templateModel.put("brand", completedOrder.getBrand());
        templateModel.put("model", completedOrder.getModel());
        templateModel.put("itemCondition", completedOrder.getItemCondition());
        templateModel.put("size", completedOrder.getSize());
        templateModel.put("price", completedOrder.getPrice());
        templateModel.put("deliveryPrice", completedOrder.getDeliveryPrice());
        templateModel.put("discount", completedOrder.getDiscount());
        templateModel.put("orderTotal", completedOrder.getOrderTotal());

        Template template = freemarkerConfigurer.getConfiguration().getTemplate("successfulOrder-message-eng.ftl");
        String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel);

        sendEmailByEmailAndSubjectAndHtmlBody(completedOrder.getEmail(), "The order has been successfully completed", htmlBody);

    }

}


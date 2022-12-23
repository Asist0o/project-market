package market.service;

import freemarker.template.TemplateException;
import market.model.Message;

import javax.mail.MessagingException;
import java.io.IOException;

public interface ConsumerService {
    //public void consume(Message message);

    public void onProfileCreated(String message) throws TemplateException, MessagingException, IOException;
}

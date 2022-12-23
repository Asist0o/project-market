package market.dto;

import market.model.MailLanguages;

public class MailMessageDto {
    private String to;
    private String username;
    private String subject;
    private MailLanguages mailLanguages;

    public MailMessageDto(String to, String username, String subject, MailLanguages mailLanguages) {
        this.to = to;
        this.username = username;
        this.subject = subject;
        this.mailLanguages = mailLanguages;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MailLanguages getMailLanguages() {
        return mailLanguages;
    }

    public void setMailLanguages(MailLanguages mailLanguages) {
        this.mailLanguages = mailLanguages;
    }
}

package market.dto;

import market.model.EmailType;

public class EmailSendEventDto {
    private Long accountId;
    private EmailType emailType;

    public EmailSendEventDto(Long accountId, EmailType emailType) {
        this.accountId = accountId;
        this.emailType = emailType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }
}

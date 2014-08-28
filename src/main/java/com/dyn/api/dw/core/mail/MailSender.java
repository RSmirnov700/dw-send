package com.dyn.api.dw.core.mail;

public interface MailSender {
    void send(EmailContent emailContent) throws Exception;
}

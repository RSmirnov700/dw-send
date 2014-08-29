package com.dyn.api.dw.core.mail;

import com.dyn.api.dw.config.ApplicationConfig;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailSenderImpl implements MailSender {
    private final String smtpHost;
    private final String smtpPort;
    private final String username;
    private final String password;

    @Inject
    public MailSenderImpl(ApplicationConfig applicationConfig) {
        this.smtpHost = applicationConfig.getSmtpHost();
        this.smtpPort = applicationConfig.getSmtpPort();
        this.username = applicationConfig.getSmtpUsername();
        this.password = applicationConfig.getSmtpPassword();
    }

    private List<InternetAddress> parseAddresses(List<String> addresses) throws AddressException {
        List<InternetAddress> result = new ArrayList<>();
        for (String address : addresses) {
            InternetAddress[] parsed = InternetAddress.parse(address);
            if (parsed.length != 1) {
                throw new AddressException("Illegal address", address);
            }
            result.add(parsed[0]);
        }
        return result;
    }

    @Override
    public void send(EmailContent emailContent) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(emailContent.getFrom()));
        List<InternetAddress> toAddresses = parseAddresses(emailContent.getTo());
        msg.setRecipients(Message.RecipientType.TO, toAddresses.toArray(new Address[toAddresses.size()]));
        msg.setSubject(emailContent.getSubject());
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailContent.getMessage(), emailContent.getType().getIsoType());

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        if (!emailContent.getAttachments().isEmpty()) {
            for (Attachment attachment : emailContent.getAttachments()) {
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setDisposition(MimeBodyPart.ATTACHMENT);
                mimeBodyPart.setFileName(attachment.getName());
                mimeBodyPart.setDataHandler(new DataHandler(
                        new ByteArrayDataSource(attachment.getContent(), attachment.getContentType())));
                multipart.addBodyPart(mimeBodyPart);
            }
        }

        msg.setContent(multipart);

        Transport.send(msg);
    }
}

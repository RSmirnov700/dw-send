package com.dyn.api.dw.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dyn.api.dw.core.mail.EmailContent;
import com.dyn.api.dw.core.mail.MailSender;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyn.api.dw.annotation.QueryBeanParam;
import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.api.ResponseMessage;
import com.dyn.api.dw.validator.RequestMessageValidator;
import com.google.inject.Inject;

import static com.dyn.api.dw.core.mail.EmailContent.Type.HTML;
import static com.dyn.api.dw.core.mail.EmailContent.Type.PLAIN_TEXT;

@Path("/send")
@Produces(MediaType.APPLICATION_JSON)
public class SendMessageResource {
    private static final Logger LOG = LoggerFactory.getLogger(SendMessageResource.class);

	private RequestMessageValidator validator;

    private MailSender mailSender;

    @Inject
	public SendMessageResource (RequestMessageValidator validator, MailSender mailSender) {
		this.validator = validator;
        this.mailSender = mailSender;
        LOG.info("Injected Validator is " + validator);
	}

	@POST
	public ResponseMessage send(@QueryBeanParam RequestMessage message) {
		if (!validator.isValid(message)) {
			return new ResponseMessage(RequestMessageValidator.INVALID_FIELD_ERROR_CODE, "KO", validator.createErrorMessage(message));
		}
        try {
            EmailContent emailContent = new EmailContent();
            emailContent.setFrom(message.getFrom());
            List<String> toAddresses = Lists.newArrayList(Splitter.on(",").trimResults().omitEmptyStrings().split(message.getTo()));
            emailContent.setTo(toAddresses);
            emailContent.setSubject(message.getSubject());
            emailContent.setType(!Strings.isNullOrEmpty(message.getBodyHtml()) ? HTML : PLAIN_TEXT);
            emailContent.setMessage(!Strings.isNullOrEmpty(message.getBodyHtml()) ? message.getBodyHtml() : message.getBodyText());
            mailSender.send(emailContent);
        } catch (Exception e) {
            new ResponseMessage(200, "OK", "Error occurred while sending email" + e.getMessage());
        }
        return new ResponseMessage(200, "OK", new Date().toString() + " " + message.getSubject());
	}

}

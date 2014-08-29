package com.dyn.api.dw.resources;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyn.api.dw.annotation.QueryBeanParam;
import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.api.ResponseMessage;
import com.dyn.api.dw.validator.RequestMessageValidator;
import com.google.inject.Inject;

@Path("/send")
@Produces(MediaType.APPLICATION_JSON)
public class SendMessageResource {
    private static final Logger LOG = LoggerFactory.getLogger(SendMessageResource.class);

	private RequestMessageValidator validator;

    @Inject
	public SendMessageResource (RequestMessageValidator validator) {
		this.validator = validator;
        LOG.info("Injected Validator is " + validator);
	}

	@POST
	public ResponseMessage send(@QueryBeanParam RequestMessage message) {
		if (!validator.isValid(message)) {
			return new ResponseMessage(RequestMessageValidator.INVALID_FIELD_ERROR_CODE, "KO", validator.createErrorMessage(message));
		}
		
		return new ResponseMessage(200, "OK", new Date().toString() + " " + message.getSubject());
	}

}

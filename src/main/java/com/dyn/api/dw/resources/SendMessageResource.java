package com.dyn.api.dw.resources;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dyn.api.dw.annotation.QueryBeanParam;
import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.api.ResponseMessage;

@Path("/send")
@Produces(MediaType.APPLICATION_JSON)
public class SendMessageResource {
	
	private Validator validator;
	
	public SendMessageResource (Validator validator) {
		this.validator = validator;
	}

	@POST
	public ResponseMessage send(@QueryBeanParam RequestMessage message) {
		Set<ConstraintViolation<RequestMessage>> validate = validator.validate(message);
		System.out.println(validate);
		return new ResponseMessage(1, message.getApiKey(), message.getSubject());
	}

}

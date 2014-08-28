package com.dyn.api.dw.resources;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dyn.api.dw.annotation.QueryBeanParam;
import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.api.ResponseMessage;
import com.dyn.api.dw.guice.modules.NamedModuleProvider;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/send")
@Produces(MediaType.APPLICATION_JSON)
public class SendMessageResource {
    private static final Logger LOG = LoggerFactory.getLogger(SendMessageResource.class);

	private Validator validator;

    @Inject
	public SendMessageResource ( @Named(NamedModuleProvider.REQUEST_VALIDATOR) Validator validator) {
		this.validator = validator;
        LOG.info("Injected Validator is " + validator);
	}

	@POST
	public ResponseMessage send(@QueryBeanParam @Valid RequestMessage message) {
		Set<ConstraintViolation<RequestMessage>> validate = validator.validate(message);
		System.out.println(validate);
		return new ResponseMessage(1, message.getApiKey(), message.getSubject());
	}

}

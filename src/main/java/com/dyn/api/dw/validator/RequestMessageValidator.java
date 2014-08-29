package com.dyn.api.dw.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.guice.modules.NamedModuleProvider;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class RequestMessageValidator {

	public static final int INVALID_FIELD_ERROR_CODE = 452;

	private static final Logger LOG = LoggerFactory.getLogger(RequestMessageValidator.class);

	private Validator validator;

	@Inject
	public RequestMessageValidator(@Named(NamedModuleProvider.REQUEST_VALIDATOR) Validator validator) {
		this.validator = validator;
		LOG.info("Injected Validator is " + validator);
	}

	public boolean isValid(RequestMessage message) {
		Set<ConstraintViolation<RequestMessage>> constraintViolations = validator.validate(message);
		return constraintViolations.isEmpty();
	}

	public String createErrorMessage(RequestMessage message) {
		StringBuilder builder = new StringBuilder(INVALID_FIELD_ERROR_CODE).append(" ");
		Set<ConstraintViolation<RequestMessage>> constraintViolations = validator.validate(message);
		for (ConstraintViolation<RequestMessage> constraintViolation : constraintViolations) {
			builder.append("Parameter: '").append(constraintViolation.getPropertyPath()).append("' ").append(constraintViolation.getMessage()).append(". ");
		}

		builder.delete(builder.length() - 1, builder.length());

		return builder.toString();
	}

}

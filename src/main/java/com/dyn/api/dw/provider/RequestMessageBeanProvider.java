package com.dyn.api.dw.provider;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.dyn.api.dw.annotation.QueryBeanParam;
import com.dyn.api.dw.api.RequestMessage;
import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

public class RequestMessageBeanProvider implements InjectableProvider<QueryBeanParam, Parameter> {
	
	private interface RequestParameter {
		String X_HEADERS = "xheaders";
		String BODY_HTML = "bodyhtml";
		String BODY_TEXT = "bodytext";
		String RESENT_MESSAGE_ID = "resent-messageid";
		String RESENT_REPLY_TO = "resent-replyto";
		String RESENT_SENDER = "resent-sender";
		String RESENT_FROM = "resent-from";
		String RESENT_DATE = "resent-date";
		String SENSITIVITY = "sensitivity";
		String PRIORITY = "priority";
		String IMPORTANCE = "importance";
		String REPLY_BY = "replyby";
		String KEYWORDS = "keywords";
		String COMMENTS = "comments";
		String REFERENCES = "references";
		String IN_REPLY_TO = "inreplyto";
		String MESSAGE_ID = "messageid";
		String SENDER = "sender";
		String BCC = "bcc";
		String CC = "cc";
		String REPLY_TO = "replyto";
		String SUBJECT = "subject";
		String TO = "to";
		String FROM = "from";
		String API_KEY = "apikey";
	}

	
	@Context
	private UriInfo uriInfo;

	@Override
	public Injectable<RequestMessage> getInjectable(ComponentContext ic, final QueryBeanParam a, final Parameter c) {

		if (RequestMessage.class != c.getParameterClass()) {
			return null;
		}

		return new Injectable<RequestMessage>() {

			public RequestMessage getValue() {
				RequestMessage.RequestMessageBuilder bean = new RequestMessage.RequestMessageBuilder();
				MultivaluedMap<String, String> params = uriInfo.getQueryParameters();

				// TODO is there a better way to do this?

				bean.apiKey(getParameter(params, RequestParameter.API_KEY))
						.from(getParameter(params, RequestParameter.FROM))
						.to(getParameter(params, RequestParameter.TO))
						.subject(getParameter(params, RequestParameter.SUBJECT))
						.replyTo(getParameter(params, RequestParameter.REPLY_TO))
						.cc(getParameter(params, RequestParameter.CC))
						.bcc(getParameter(params, RequestParameter.BCC))
						.sender(getParameter(params, RequestParameter.SENDER))
						.messageId(getParameter(params, RequestParameter.MESSAGE_ID))
						.inReplyTo(getParameter(params, RequestParameter.IN_REPLY_TO))
						.references(getParameter(params, RequestParameter.REFERENCES))
						.comments(getParameter(params, RequestParameter.COMMENTS))
						.keywords(getParameter(params, RequestParameter.KEYWORDS))
						.replyBy(getParameter(params, RequestParameter.REPLY_BY))
						.importance(getParameter(params, RequestParameter.IMPORTANCE))
						.priority(getParameter(params, RequestParameter.PRIORITY))
						.sensitivity(getParameter(params, RequestParameter.SENSITIVITY))
						.resentDate(getParameter(params, RequestParameter.RESENT_DATE))
						.resentFrom(getParameter(params, RequestParameter.RESENT_FROM))
						.resentSender(getParameter(params, RequestParameter.RESENT_SENDER))
						.resentReplyTo(getParameter(params, RequestParameter.RESENT_REPLY_TO))
						.resentMessageId(getParameter(params, RequestParameter.RESENT_MESSAGE_ID))
						.bodyText(getParameter(params, RequestParameter.BODY_TEXT))
						.bodyHtml(getParameter(params, RequestParameter.BODY_HTML))
						.xHeaders(getParameter(params, RequestParameter.X_HEADERS));

				return bean.build();
			}

		};
	}

	private String getParameter(MultivaluedMap<String, String> params, String key) {
		List<String> list = params.get(key);
		if (list != null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public ComponentScope getScope() {
		return ComponentScope.PerRequest;
	}

}

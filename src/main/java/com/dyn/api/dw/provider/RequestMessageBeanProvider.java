package com.dyn.api.dw.provider;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.dyn.api.dw.annotation.QueryBeanParam;
import com.dyn.api.dw.api.RequestMessage;
import com.dyn.api.dw.api.RequestMessageBuilder;
import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

public class RequestMessageBeanProvider implements InjectableProvider<QueryBeanParam, Parameter> {

	@Context
	private UriInfo uriInfo;

	@Override
	public Injectable<RequestMessage> getInjectable(ComponentContext ic, final QueryBeanParam a, final Parameter c) {

		if (RequestMessage.class != c.getParameterClass()) {
			return null;
		}

		return new Injectable<RequestMessage>() {

			public RequestMessage getValue() {
				RequestMessageBuilder bean = new RequestMessageBuilder();
				MultivaluedMap<String, String> params = uriInfo.getQueryParameters();

				// TODO is there a better way to do this?

				bean.setApiKey(getParameter(params, "apikey"));
				bean.setFrom(getParameter(params, "from"));
				bean.setTo(getParameter(params, "to"));
				bean.setSubject(getParameter(params, "subject"));
				bean.setReplyTo(getParameter(params, "replyto"));
				bean.setCc(getParameter(params, "cc"));
				bean.setBcc(getParameter(params, "bcc"));
				bean.setSender(getParameter(params, "sender"));
				bean.setMessageId(getParameter(params, "messageid"));
				bean.setInReplyTo(getParameter(params, "inreplyto"));
				bean.setReferences(getParameter(params, "references"));
				bean.setComments(getParameter(params, "comments"));
				bean.setKeywords(getParameter(params, "keywords"));
				bean.setReplyBy(getParameter(params, "replyby"));
				bean.setImportance(getParameter(params, "importance"));
				bean.setPriority(getParameter(params, "priority"));
				bean.setSensitivity(getParameter(params, "sensitivity"));
				bean.setResentDate(getParameter(params, "resent-date"));
				bean.setResentFrom(getParameter(params, "resent-from"));
				bean.setResentSender(getParameter(params, "resent-sender"));
				bean.setResentReplyTo(getParameter(params, "resent-replyto"));
				bean.setResentMessageId(getParameter(params, "resent-messageid"));
				bean.setBodyText(getParameter(params, "bodytext"));
				bean.setBodyHtml(getParameter(params, "bodyhtml"));
				bean.setxHeaders(getParameter(params, "xheaders"));

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

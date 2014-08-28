package com.dyn.api.dw.api;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestMessage {

	@NotEmpty
	@JsonProperty(required = true, value = "apikey")
	private final String apiKey;

	@NotEmpty
	@Email
	@JsonProperty(required = true)
	private final String from;

	@NotEmpty
	@Email
	@JsonProperty(required = true)
	private final String to;

	@NotEmpty
	@JsonProperty(required = true)
	private final String subject;

	@Email
	@JsonProperty("replyto")
	private final String replyTo;

	@Email
	private final String cc;

	@Email
	private final String bcc;

	@Email
	private final String sender;

	@JsonProperty("messageid")
	private final String messageId;

	@JsonProperty("inreplyto")
	private final String inReplyTo;

	private final String references;

	private final String comments;

	private final String keywords;

	@JsonProperty("replyby")
	private final String replyBy;

	private final String importance;

	private final String priority;

	private final String sensitivity;

	@JsonProperty("resent-date")
	private final String resentDate;

	@JsonProperty("resent-from")
	private final String resentFrom;

	@JsonProperty("resent-sender")
	private final String resentSender;

	@JsonProperty("resent-replyto")
	private final String resentReplyTo;

	@JsonProperty("resent-messageid")
	private final String resentMessageId;

	@JsonProperty("bodytext")
	private final String bodyText;

	@JsonProperty("bodyhtml")
	private final String bodyHtml;

	@JsonProperty("xheaders")
	private final String xHeaders;

	public RequestMessage(RequestMessageBuilder builder) {
		apiKey = builder.getApiKey();
		from = builder.getFrom();
		to = builder.getTo();
		subject = builder.getSubject();
		replyTo = builder.getReplyTo();
		cc = builder.getCc();
		bcc = builder.getBcc();
		sender = builder.getSender();
		messageId = builder.getMessageId();
		inReplyTo = builder.getInReplyTo();
		references = builder.getReferences();
		comments = builder.getComments();
		keywords = builder.getKeywords();
		replyBy = builder.getReplyBy();
		importance = builder.getImportance();
		priority = builder.getPriority();
		sensitivity = builder.getSensitivity();
		resentDate = builder.getResentDate();
		resentFrom = builder.getResentFrom();
		resentSender = builder.getResentSender();
		resentReplyTo = builder.getResentReplyTo();
		resentMessageId = builder.getResentMessageId();
		bodyText = builder.getBodyText();
		bodyHtml = builder.getBodyHtml();
		xHeaders = builder.getxHeaders();
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public String getCc() {
		return cc;
	}

	public String getBcc() {
		return bcc;
	}

	public String getSender() {
		return sender;
	}

	public String getMessageId() {
		return messageId;
	}

	public String getInReplyTo() {
		return inReplyTo;
	}

	public String getReferences() {
		return references;
	}

	public String getComments() {
		return comments;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getReplyBy() {
		return replyBy;
	}

	public String getImportance() {
		return importance;
	}

	public String getPriority() {
		return priority;
	}

	public String getSensitivity() {
		return sensitivity;
	}

	public String getResentDate() {
		return resentDate;
	}

	public String getResentFrom() {
		return resentFrom;
	}

	public String getResentSender() {
		return resentSender;
	}

	public String getResentReplyTo() {
		return resentReplyTo;
	}

	public String getResentMessageId() {
		return resentMessageId;
	}

	public String getBodyText() {
		return bodyText;
	}

	public String getBodyHtml() {
		return bodyHtml;
	}

	public String getxHeaders() {
		return xHeaders;
	}

}

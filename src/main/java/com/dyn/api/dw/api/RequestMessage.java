package com.dyn.api.dw.api;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RequestMessage {

	@NotEmpty
	private final String apiKey;

	@NotEmpty
	@Email
	private final String from;

	@NotEmpty
	@Email
	private final String to;

	@NotEmpty
	private final String subject;

	@Email
	private final String replyTo;

	@Email
	private final String cc;

	@Email
	private final String bcc;

	@Email
	private final String sender;

	private final String messageId;

	private final String inReplyTo;

	private final String references;

	private final String comments;

	private final String keywords;

	private final String replyBy;

	private final String importance;

	private final String priority;

	private final String sensitivity;

	private final String resentDate;

	private final String resentFrom;

	private final String resentSender;

	private final String resentReplyTo;

	private final String resentMessageId;

	private final String bodyText;

	private final String bodyHtml;

	private final String xHeaders;

	private RequestMessage(RequestMessageBuilder builder) {
		apiKey = builder.apiKey;
		from = builder.from;
		to = builder.to;
		subject = builder.subject;
		replyTo = builder.replyTo;
		cc = builder.cc;
		bcc = builder.bcc;
		sender = builder.sender;
		messageId = builder.messageId;
		inReplyTo = builder.inReplyTo;
		references = builder.references;
		comments = builder.comments;
		keywords = builder.keywords;
		replyBy = builder.replyBy;
		importance = builder.importance;
		priority = builder.priority;
		sensitivity = builder.sensitivity;
		resentDate = builder.resentDate;
		resentFrom = builder.resentFrom;
		resentSender = builder.resentSender;
		resentReplyTo = builder.resentReplyTo;
		resentMessageId = builder.resentMessageId;
		bodyText = builder.bodyText;
		bodyHtml = builder.bodyHtml;
		xHeaders = builder.xHeaders;
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
	
	public static class RequestMessageBuilder {

		private String apiKey;
		private String from;
		private String to;
		private String subject;
		private String replyTo;
		private String cc;
		private String bcc;
		private String sender;
		private String messageId;
		private String inReplyTo;
		private String references;
		private String comments;
		private String keywords;
		private String replyBy;
		private String importance;
		private String priority;
		private String sensitivity;
		private String resentDate;
		private String resentFrom;
		private String resentSender;
		private String resentReplyTo;
		private String resentMessageId;
		private String bodyText;
		private String bodyHtml;
		private String xHeaders;

		public RequestMessage build() {
			return new RequestMessage(this);
		}

		public RequestMessageBuilder apiKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		public RequestMessageBuilder from(String from) {
			this.from = from;
			return this;
		}

		public RequestMessageBuilder to(String to) {
			this.to = to;
			return this;
		}

		public RequestMessageBuilder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public RequestMessageBuilder replyTo(String replyTo) {
			this.replyTo = replyTo;
			return this;
		}

		public RequestMessageBuilder cc(String cc) {
			this.cc = cc;
			return this;
		}

		public RequestMessageBuilder bcc(String bcc) {
			this.bcc = bcc;
			return this;
		}

		public RequestMessageBuilder sender(String sender) {
			this.sender = sender;
			return this;
		}

		public RequestMessageBuilder messageId(String messageId) {
			this.messageId = messageId;
			return this;
		}

		public RequestMessageBuilder inReplyTo(String inReplyTo) {
			this.inReplyTo = inReplyTo;
			return this;
		}

		public RequestMessageBuilder references(String references) {
			this.references = references;
			return this;
		}

		public RequestMessageBuilder comments(String comments) {
			this.comments = comments;
			return this;
		}

		public RequestMessageBuilder keywords(String keywords) {
			this.keywords = keywords;
			return this;
		}

		public RequestMessageBuilder replyBy(String replyBy) {
			this.replyBy = replyBy;
			return this;
		}

		public RequestMessageBuilder importance(String importance) {
			this.importance = importance;
			return this;
		}

		public RequestMessageBuilder priority(String priority) {
			this.priority = priority;
			return this;
		}

		public RequestMessageBuilder sensitivity(String sensitivity) {
			this.sensitivity = sensitivity;
			return this;
		}

		public RequestMessageBuilder resentDate(String resentDate) {
			this.resentDate = resentDate;
			return this;
		}

		public RequestMessageBuilder resentFrom(String resentFrom) {
			this.resentFrom = resentFrom;
			return this;
		}

		public RequestMessageBuilder resentSender(String resentSender) {
			this.resentSender = resentSender;
			return this;
		}

		public RequestMessageBuilder resentReplyTo(String resentReplyTo) {
			this.resentReplyTo = resentReplyTo;
			return this;
		}

		public RequestMessageBuilder resentMessageId(String resentMessageId) {
			this.resentMessageId = resentMessageId;
			return this;
		}

		public RequestMessageBuilder bodyText(String bodyText) {
			this.bodyText = bodyText;
			return this;
		}

		public RequestMessageBuilder bodyHtml(String bodyHtml) {
			this.bodyHtml = bodyHtml;
			return this;
		}

		public RequestMessageBuilder xHeaders(String xHeaders) {
			this.xHeaders = xHeaders;
			return this;
		}
	}

}

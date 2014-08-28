package com.dyn.api.dw.api;

public class RequestMessageBuilder {

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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(String inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getReplyBy() {
		return replyBy;
	}

	public void setReplyBy(String replyBy) {
		this.replyBy = replyBy;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(String sensitivity) {
		this.sensitivity = sensitivity;
	}

	public String getResentDate() {
		return resentDate;
	}

	public void setResentDate(String resentDate) {
		this.resentDate = resentDate;
	}

	public String getResentFrom() {
		return resentFrom;
	}

	public void setResentFrom(String resentFrom) {
		this.resentFrom = resentFrom;
	}

	public String getResentSender() {
		return resentSender;
	}

	public void setResentSender(String resentSender) {
		this.resentSender = resentSender;
	}

	public String getResentReplyTo() {
		return resentReplyTo;
	}

	public void setResentReplyTo(String resentReplyTo) {
		this.resentReplyTo = resentReplyTo;
	}

	public String getResentMessageId() {
		return resentMessageId;
	}

	public void setResentMessageId(String resentMessageId) {
		this.resentMessageId = resentMessageId;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getBodyHtml() {
		return bodyHtml;
	}

	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}

	public String getxHeaders() {
		return xHeaders;
	}

	public void setxHeaders(String xHeaders) {
		this.xHeaders = xHeaders;
	}

	public RequestMessage build() {
		return new RequestMessage(this);
	}
}

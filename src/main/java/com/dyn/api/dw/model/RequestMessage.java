package com.dyn.api.dw.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestMessage {

	@NotEmpty
	@JsonProperty(required = true, value = "apikey" )
	private String apiKey;
	
	@NotEmpty
	@Email
	@JsonProperty(required = true)
	private String from;
	
	@NotEmpty
	@Email
	@JsonProperty(required = true)
	private String to;
	
	@NotEmpty
	@JsonProperty(required = true)
	private String subject;
	
	@Email
	@JsonProperty("replyto")
	private String replyTo; 
	
	@Email
	@JsonProperty
	private String cc;
	
	@Email
	@JsonProperty
	private String bcc; 
	
	@Email
	@JsonProperty
	private String sender; 
	
	@JsonProperty("messageid")
	private String messageId;
	
	@JsonProperty("inreplyto")
	private String inReplyTo;
	
	private String references;
	
	private String comments;
	
	private String keywords;
	
	@JsonProperty("replyby")
	private String replyBy;
	
	private String importance;
	
	private String priority;
	
	private String sensitivity;
	
	@JsonProperty("resent-date")
	private String resentDate;
	
	@JsonProperty("resent-from")
	private String resentFrom;
	
	@JsonProperty ("resent-sender")
	private String resentSender;
	
	@JsonProperty ("resent-replyto")
	private String resentReplyTo;

	@JsonProperty ("resent-messageid")
	private String resentMessageId;
	
	@JsonProperty ("bodytext")
	private String bodyText;
	
	@JsonProperty ("bodyhtml")
	private String bodyHtml;
	
	@JsonProperty ("xheaders")
	private String xHeaders;
	
}

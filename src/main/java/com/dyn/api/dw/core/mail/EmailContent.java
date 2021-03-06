package com.dyn.api.dw.core.mail;

import com.google.common.collect.Lists;

import java.util.List;

public class EmailContent {
    public enum Type {
        HTML("text/html"), PLAIN_TEXT("text/plain");
        private String isoType;

        Type(String isoType) {
            this.isoType = isoType;
        }

        public String getIsoType() {
            return isoType;
        }
    }

    private String from;
    private String subject;
    private List<String> to = Lists.newArrayList();
    private List<String> cc = Lists.newArrayList();
    private String message;
    private List<Attachment> attachments = Lists.newArrayList();
    private Type type;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

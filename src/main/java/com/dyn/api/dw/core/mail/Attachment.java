package com.dyn.api.dw.core.mail;

public class Attachment {
    private String name;
    private String contentType;
    private byte[] content;

    public Attachment() {
    }

    public Attachment(String name, String contentType, byte[] content) {
        super();
        this.name = name;
        this.contentType = contentType;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

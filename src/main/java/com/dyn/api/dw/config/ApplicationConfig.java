package com.dyn.api.dw.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ApplicationConfig extends Configuration {

    @NotEmpty
    private String smtpHost;

    @NotEmpty
    private String smtpPort;

    @NotEmpty
    private String smtpUsername;

    @NotEmpty
    private String smtpPassword;

    @JsonProperty
    public String getSmtpHost() {
        return smtpHost;
    }

    @JsonProperty
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    @JsonProperty
    public String getSmtpPort() {
        return smtpPort;
    }

    @JsonProperty
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    @JsonProperty
    public String getSmtpUsername() {
        return smtpUsername;
    }

    @JsonProperty
    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    @JsonProperty
    public String getSmtpPassword() {
        return smtpPassword;
    }

    @JsonProperty
    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }
}

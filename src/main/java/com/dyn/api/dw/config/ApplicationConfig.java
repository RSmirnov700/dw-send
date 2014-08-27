package com.dyn.api.dw.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by rsmirnov on 8/27/14.
 */
public class ApplicationConfig extends Configuration {
    @NotEmpty
    private String smtpHost;

    @JsonProperty
    public String getSmtpHost() {
        return smtpHost;
    }

    @JsonProperty
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }
}

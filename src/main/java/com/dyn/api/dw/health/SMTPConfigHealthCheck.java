package com.dyn.api.dw.health;

import com.codahale.metrics.health.HealthCheck;
import com.dyn.api.dw.guice.modules.NamedModuleProvider;
import com.dyn.api.dw.util.SmtpValueValidator;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SMTPConfigHealthCheck extends HealthCheck {

    private final String smtpHost;
    private final SmtpValueValidator validator;

    @Inject
    public SMTPConfigHealthCheck(@Named(NamedModuleProvider.SMTP_HOST)String smtpHost, SmtpValueValidator validator) {
        this.smtpHost = smtpHost;
        this.validator = validator;
    }

    @Override
    protected Result check() throws Exception {
        return validator.validate(this.smtpHost) ? HealthCheck.Result.healthy() :
            HealthCheck.Result.unhealthy("smtpHost value " +smtpHost + " is invalid. Please specify FQDN or IP address");
    }
}

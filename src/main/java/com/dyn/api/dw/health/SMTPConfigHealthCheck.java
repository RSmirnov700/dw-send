package com.dyn.api.dw.health;

import com.codahale.metrics.health.HealthCheck;
import com.dyn.api.dw.guice.modules.NamedModuleProvider;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

public class SMTPConfigHealthCheck extends HealthCheck {
    private final String smtpHost;

    @Inject
    public SMTPConfigHealthCheck(@Named(NamedModuleProvider.SMTP_HOST)String smtpHost) {
        this.smtpHost = smtpHost;
    }

    @Override
    protected Result check() throws Exception {
        //TODO add validation for domain name/IP for smtpHost in config including value validation;
        if (Strings.isNullOrEmpty(smtpHost)) {
            return HealthCheck.Result.unhealthy("smtpHost value isn't defined in configuration file."+
                    " Please specify FQDN or IP of SMTP host");
        }
        return HealthCheck.Result.healthy();

    }
}

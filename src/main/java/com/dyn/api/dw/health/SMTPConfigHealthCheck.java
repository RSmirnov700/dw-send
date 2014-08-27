package com.dyn.api.dw.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.common.base.Strings;

/**
 * Created by rsmirnov on 8/27/14.
 */
public class SMTPConfigHealthCheck extends HealthCheck {
    private final String smtpHost;

    public SMTPConfigHealthCheck(String smtpHost) {
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

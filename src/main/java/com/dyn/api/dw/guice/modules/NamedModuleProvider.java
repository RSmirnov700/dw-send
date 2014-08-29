package com.dyn.api.dw.guice.modules;

import com.dyn.api.dw.config.ApplicationConfig;
import com.dyn.api.dw.core.mail.MailSender;
import com.dyn.api.dw.core.mail.MailSenderImpl;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import io.dropwizard.setup.Environment;

import javax.validation.Validator;

public class NamedModuleProvider implements Module {
    public static final String SMTP_HOST = "smtpHost";
    public static final String REQUEST_VALIDATOR = "requestValidator";

    @Override
    public void configure(Binder binder) {
        binder.bind(MailSender.class).to(MailSenderImpl.class);
    }

    @Provides
    @Named(SMTP_HOST)
    public String provideSmtpHost(ApplicationConfig appConfig) {
        return appConfig.getSmtpHost();
    }

    @Provides
    @Named(REQUEST_VALIDATOR)
    public Validator provideBeanValidator(Environment environment) {
        return environment.getValidator();
    }
}

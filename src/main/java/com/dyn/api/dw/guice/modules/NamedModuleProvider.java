package com.dyn.api.dw.guice.modules;

import com.dyn.api.dw.config.ApplicationConfig;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class NamedModuleProvider implements Module {
    public static final String SMTP_HOST = "smtpHost";
    @Override
    public void configure(Binder binder) {
    }

    @Provides
    @Named(SMTP_HOST)
    public String provideSmtpHost(ApplicationConfig appConfig) {
        return appConfig.getSmtpHost();
    }
}

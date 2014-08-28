package com.dyn.api.dw.guice;

import com.dyn.api.dw.config.ApplicationConfig;
import com.dyn.api.dw.guice.modules.NamedModuleProvider;
import com.google.inject.Injector;
import com.hubspot.dropwizard.guice.GuiceBundle;

public class GuiceBundleFactory {
    private static GuiceBundleFactory instance = new GuiceBundleFactory();
    private GuiceBundle<ApplicationConfig> guiceBundle;

    private GuiceBundleFactory() {
        this.guiceBundle = GuiceBundle.<ApplicationConfig>newBuilder()
                .addModule(new NamedModuleProvider())
                .setConfigClass(ApplicationConfig.class)
                .build();
    }

    public static GuiceBundleFactory getInstance() {
        return instance;
    }

    public GuiceBundle getBundle() {
        return this.guiceBundle;
    }

    public Injector getInjector() {
        return this.guiceBundle.getInjector();
    }


}

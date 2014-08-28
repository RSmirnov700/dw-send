package com.dyn.api.dw;

import com.dyn.api.dw.config.ApplicationConfig;
import com.dyn.api.dw.guice.GuiceBundleFactory;
import com.dyn.api.dw.health.SMTPConfigHealthCheck;
import com.dyn.api.dw.resources.SimpleTestResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.dyn.api.dw.config.ApplicationConfig;
import com.dyn.api.dw.health.SMTPConfigHealthCheck;
import com.dyn.api.dw.provider.RequestMessageBeanProvider;
import com.dyn.api.dw.resources.SendMessageResource;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Created by rsmirnov on 8/27/14.
 */

public class ServerMainApp extends Application<ApplicationConfig> {

    @Override
    public void initialize(Bootstrap<ApplicationConfig> applicationConfigBootstrap) {
        applicationConfigBootstrap.addBundle(GuiceBundleFactory.getInstance().getBundle());
    }

    @Override
    public void run(ApplicationConfig applicationConfig, Environment environment) throws Exception {
        //Here goes resources and health checks initialization
        //TODO add resources initialization
        environment.healthChecks().register("smtp",
                GuiceBundleFactory.getInstance().getInjector().getInstance(SMTPConfigHealthCheck.class));
    }

    public static void main(String[] args) throws Exception {
        new ServerMainApp().run(args);
    }
}

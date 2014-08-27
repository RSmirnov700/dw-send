package com.dyn.api.dw;

import com.dyn.api.dw.config.ApplicationConfig;
import com.dyn.api.dw.health.SMTPConfigHealthCheck;
import com.dyn.api.dw.resources.SendMessageResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by rsmirnov on 8/27/14.
 */
public class ServerMainApp extends Application<ApplicationConfig> {

    @Override
    public void initialize(Bootstrap<ApplicationConfig> applicationConfigBootstrap) {

    }

    @Override
    public void run(ApplicationConfig applicationConfig, Environment environment) throws Exception {
        //Here goes resources and health checks initialization
        //TODO add resources initialization
        /*
        final SomeResource resource = new SomeResource(args.....);
        environment.jersey().register(resource);
        */
        final SMTPConfigHealthCheck smtpCheck =
                new SMTPConfigHealthCheck(applicationConfig.getSmtpHost());
        environment.healthChecks().register("smtp", smtpCheck);
        
        final SendMessageResource resource = new SendMessageResource();
        
        environment.jersey().register(resource);
    }

    public static void main(String[] args) throws Exception {
        new ServerMainApp().run(args);
    }
}

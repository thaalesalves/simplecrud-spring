package es.thalesalv.simplecrud.application.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(Profiles.ENGLISH)
public class EnglishMessageConstants implements MessageConstants {

    @Value("${vars.message}")
    private String messageVar;

    @Value("${vars.openshift}")
    private String openshift;

    @Value("${spring.profiles.active}")
    private String appProfile;

    @Override
    public String profile() {
        return Profiles.ENGLISH;
    }

    @Override
    public String messageKey() {
        return "Message";
    }

    @Override
    public String languageKey() {
        return "This application is running in";
    }

    @Override
    public String languageValue() {
        return "English";
    }

    @Override
    public String bookNotFoundMessage() {
        return "Oops! Book not found :: ";
    }

    @Override
    public String openshiftKey() {
        return "OpenShift is way too";
    }

    @Override
    public String messageForEveryoneKey() {
        return "Message to everyone";
    }

    @Override
    public String helloWorld() {
        return "Hello, World!";
    }

    @Override
    public String openshiftValue() {
        return openshift;
    }

    @Override
    public String messageForEveryoneValue() {
        return messageVar;
    }

    @Override
    public String profileKey() {
        return "Application profile";
    }

    @Override
    public String profileValue() {
        return appProfile;
    }

    @Override
    public String databaseKey() {
        return "Database";
    }

    @Override
    public String databaseValue() {
        return "PostgreSQL";
    }
}
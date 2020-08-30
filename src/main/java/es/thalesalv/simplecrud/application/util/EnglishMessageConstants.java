package es.thalesalv.simplecrud.application.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Profiles.ENGLISH)
public class EnglishMessageConstants implements MessageConstants {

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
}
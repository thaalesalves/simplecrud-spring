package es.thalesalv.simplecrud.application.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(Profiles.FRANCAIS)
public class FrancaisMessageConstants implements MessageConstants {

    @Value("${vars.message}")
    private String messageVar;

    @Value("${vars.openshift}")
    private String openshift;
    
    @Override
    public String profile() {
        return Profiles.FRANCAIS;
    }

    @Override
    public String messageKey() {
        return "Message";
    }

    @Override
    public String languageKey() {
        return "Cette application fonctionne en";
    }

    @Override
    public String languageValue() {
        return "français";
    }

    @Override
    public String bookNotFoundMessage() {
        return "Oups! Livre non trouvé :: ";
    }
    
    @Override
    public String openshiftKey() {
        return "OpenShift est très";
    }

    @Override
    public String messageForEveryoneKey() {
        return "Message à tous";
    }

    @Override
    public String helloWorld() {
        return "Salut le Monde!";
    }

    @Override
    public String openshiftValue() {
        return openshift;
    }

    @Override
    public String messageForEveryoneValue() {
        return messageVar;
    }
}
package es.thalesalv.simplecrud.application.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Profiles.PORTUGUES)
public class PortuguesMessageConstants implements MessageConstants {

    @Override
    public String profile() {
        return Profiles.PORTUGUES;
    }

    @Override
    public String messageKey() {
        return "Mensagem";
    }

    @Override
    public String languageKey() {
        return "Está aplicação está rodando em";
    }

    @Override
    public String languageValue() {
        return "português";
    }

    @Override
    public String bookNotFoundMessage() {
        return "Opa! Livro não encontrado :: ";
    }
    
    @Override
    public String openshiftKey() {
        return "OpenShift é muito";
    }

    @Override
    public String messageForEveryoneKey() {
        return "Mensagem a todos";
    }
}
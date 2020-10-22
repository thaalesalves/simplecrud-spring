package es.thalesalv.simplecrud.application.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({ Profiles.PORTUGUES, Profiles.DEFAULT })
public class PortuguesMessageConstants implements MessageConstants {

    @Value("${vars.message}")
    private String messageVar;

    @Value("${vars.openshift}")
    private String openshift;

    @Value("${spring.profiles.active}")
    private String appProfile;

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

    @Override
    public String helloWorld() {
        return "Olá, Mundo!";
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
        return "Perfil da aplicação";
    }

    @Override
    public String profileValue() {
        return appProfile;
    }

    @Override
    public String databaseKey() {
        return "Banco de dados";
    }

    @Override
    public String databaseValue() {
        return appProfile.equals("pt") ? "PostgreSQL" : "H2";
    }
}
#!/bin/bash

if [ "$APP_PROFILE" == "pt"]; then
    source /opt/vars_pt
elif [ "$APP_PROFILE" == "fr"]; then
    source /opt/vars_fr
elif [ "$APP_PROFILE" == "en"]; then
    source /opt/vars_en
fi

echo -e "Iniciando aplicação com o perfil \"${APP_PROFILE}\""
java -Dspring.profiles.active="$APP_PROFILE" -jar /opt/simplecrud-spring/target/simplecrud-0.0.1-SNAPSHOT.jar

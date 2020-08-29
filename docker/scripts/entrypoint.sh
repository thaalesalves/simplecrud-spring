#!/bin/bash

echo -e "Iniciando aplicação com o perfil \"${APP_PROFILE}\""
java -Dspring.profiles.active="$APP_PROFILE" -jar /opt/simplecrud-spring/target/simplecrud-0.0.1-SNAPSHOT.jar

#!/bin/bash

nohup java -Dspring.profiles.active="$APP_PROFILE" -jar /opt/simplecrud-spring/target/simplecrud-0.0.1-SNAPSHOT.jar > java_log &
tail -f java_log
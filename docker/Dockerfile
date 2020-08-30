FROM docker.io/centos:8

LABEL maintainer="Seu Nome <voce@dominio.com>"

ENV APP_PROFILE="pt"
ENV JAVA_HOME="/usr/lib/jvm/java-11-openjdk-11.0.8.10-0.el8_2.x86_64"
ENV MAVEN_HOME="/opt/apache-maven-3.6.3"

WORKDIR "/opt"

RUN yum update -y
RUN yum upgrade -y
RUN yum install -y wget tar sudo java-11-openjdk-devel java-11-openjdk git
RUN git clone https://github.com/thaalesalves/simplecrud-spring.git
RUN wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN tar xvzf apache-maven-3.6.3-bin.tar.gz
RUN chmod -R +x $MAVEN_HOME/bin
RUN $MAVEN_HOME/bin/mvn clean install -f /opt/simplecrud-spring/pom.xml

EXPOSE 8080

COPY [ "scripts/entrypoint.sh", "/opt/entrypoint.sh" ]
ENTRYPOINT [ "sh", "/opt/entrypoint.sh" ]
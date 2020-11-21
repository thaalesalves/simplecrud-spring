FROM docker.io/centos:8

LABEL maintainer="Seu Nome <voce@dominio.com>"

ENV APP_PROFILE="default"
ENV JAVA_HOME="/opt/jdk-11.0.2"
ENV MAVEN_HOME="/opt/apache-maven-3.6.3"
ENV PATH="$PATH:$MAVEN_HOME/bin:$JAVA_HOME/bin"

WORKDIR "/opt"

RUN yum update -y
RUN yum upgrade -y
RUN yum install -y wget tar git
RUN git clone https://github.com/thaalesalves/simplecrud-spring.git
RUN wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
RUN tar xvzf apache-maven-3.6.3-bin.tar.gz
RUN tar xvzf openjdk-11.0.2_linux-x64_bin.tar.gz
RUN chmod -R +x $MAVEN_HOME/bin
RUN chmod -R +x $JAVA_HOME/bin
RUN $MAVEN_HOME/bin/mvn clean install -f /opt/simplecrud-spring/pom.xml

EXPOSE 8080

COPY [ "scripts/entrypoint.sh", "/opt/entrypoint.sh" ]
ENTRYPOINT [ "sh", "/opt/entrypoint.sh" ]
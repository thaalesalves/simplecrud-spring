FROM docker.io/centos:8

ENV APP_PROFILE="pt"
ENV OPENSHIFT="cool"
ENV MESSAGE="Mas para onde vai o mundo?"

WORKDIR "/opt"

RUN yum update -y
RUN yum upgrade -y
RUN yum install -y java-11-openjdk-devel java-11-openjdk git maven
RUN git clone https://github.com/thaalesalves/simplecrud-spring.git
RUN mvn clean install -f /opt/simplecrud-spring/pom.xml

COPY [ "scripts/entrypoint.sh", "/opt/entrypoint.sh" ]
ENTRYPOINT [ "sh", "/opt/entrypoint.sh" ]
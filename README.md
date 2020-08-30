# CRUD com Spring Boot
Esta aplicação utiliza variáveis de ambiente para detectar o idioma a ser usado para imprimir as mensagens no endpoint /books, e suporte requisições GET, POST, PUT e DELETE para fazer um CRUD de dados de livros numa base de dados H2 embarcada. 

Existem dois Dockerfiles, um não otimizado e um otimizado para OpenShift. Você pode ler o tutorial completo de como compor esta imagem [aqui](https://medium.com/@thalesalves/criando-uma-imagem-docker-para-openshift-a4768a568f0a).

## Tecnologias utilizadas
- Java 11
- Maven
- Lombok
- Spring Boot
- Spring Data JPA
- Spring Web
- Banco de dados H2
- Docker (ou Podman)
- OpenShift

## Instalação
### Maven
```bash
# Faça o build da aplicação
cd simplecrud-spring
mvn clean install

# Defina o perfil a user usado (passe o perfil direto para o comando)
export APP_PROFILE="pt" # português
export APP_PROFILE="en" # inglês
export APP_PROFILE="fr" # francês

# Execute-a
java -Dspring.profiles.active="$APP_PROFILE" -jar target/simplecrud-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em http://localhost:8080/books

### Docker (ou Podman)
```bash
# Faça o build da imagem
cd simplecrud-spring/docker
docker built -t simplecrud .

# Suba um container com a imagem
docker run --name simplecrud -d -p 8080:8080 simplecrud

# Para abrir o container
docker exec -it simplecrud bash
```

A aplicação estará disponível em http://localhost:8080/books

### OpenShift (com Podman)
```bash
# Faça o build da imagem
cd simplecrud-spring/docker
podman built -t docker.io/seu_usuario/simplecrud . -f Dockerfile-openshift

# Suba a imagem para o repositório
podman push docker.io/seu_usuario/simplecrud

# Crie um projeto e um segredo para o repositório
oc new-project meuprojeto
oc create secret generic dockerio --from-file .dockerconfigjson=${XDG_RUNTIME_DIR}/containers/auth.json --type kubernetes.io/dockerconfigjson

# Vincule o segredo ao projeto
oc secrets link default dockerio --for=pull

# Crie um image stream da imagem
oc import-image simplecrud --confirm --reference-policy local --from docker.io/seu_usuario/simplecrud:latest

# Crie uma aplicação
oc new-app --name minhaaplicacao -i simplecrud

# Exponha a aplicação
oc expose svc minhaaplicacao
```

A aplicação está disponível em http://minhaaplicacao-meuprojeto.apps.cluster.openshift.com/books
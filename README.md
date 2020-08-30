# CRUD com Spring Boot
Esta é uma aplicação CRUD simples escrita em Java com Spring Boot. Foi feita para o tutorial de como criar imagens de Docker simples para o OpenShift. 

Esta aplicação utiliza variáveis de ambiente para detectar o idioma a ser usado para imprimir as mensagens no endpoint /books, e suporte requisições GET, POST, PUT e DELETE para fazer o crud de dados de livros numa base de dados H2 embarcada.

## Tecnologias utilizadas
- Java 11
- Maven
- Lombok
- Spring Boot
- Spring Data JPA
- Spring Web
- Banco de dados H2
- Docker
- OpenShift

## Instalação
```bash
# Faça o build da aplicação
mvn clean install

# Defina o perfil a user usado (passe o perfil direto para o comando)
export APP_PROFILE="pt" # português
export APP_PROFILE="en" # inglês
export APP_PROFILE="fr" # francês

# Execute-a
java -Dspring.profiles.active="$APP_PROFILE" -jar target/simplecrud-0.0.1-SNAPSHOT.jar
```

## Uso
Após subir a aplicação, ela será acessível em http://localhost:8080/books, com algumas strings impressas.

É possível usar outros endpoints para inserir, listar, atualizar e remover livros da base.
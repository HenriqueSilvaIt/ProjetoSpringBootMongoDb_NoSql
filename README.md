# Postagem e Comentários
[![NPM](https://img.shields.io/badge/licence-MIT-blue)](https://github.com/HenriqueSilvaIt/ProjectListaDeJogosJPA/blob/main/LICENSE) 

# Sobre o projeto


Postagem e comentários é uma aplicação back-end criada em uma aula da [DevSuperior](https://devsuperior.com "Site da DevSuperior").

A aplicação Postagem e comentários é uma aplicação back-end que funciona como uma rede-social porém trabalha somente com
postagem e comentários.

A aplicação trabalha com banco de dados NoSQl PostGree, lingugagem orientada a agregados.


## Como utilizar a aplicação:

### Consultar todos os jogos

https://projectlistadejogosjpa-production.up.railway.app/games

### Consulta de jogos por id

https://projectlistadejogosjpa-production.up.railway.app/games/1

### Consulta de categoria de jogos

https://projectlistadejogosjpa-production.up.railway.app/lists

### Consulta de jogos por categoria

https://projectlistadejogosjpa-production.up.railway.app/lists/1/games
https://projectlistadejogosjpa-production.up.railway.app/lists/2/games

## Modelo Conceitual
![Modelo Domínio](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)

# Tecnologias utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Implantação em produção
- Back end: Raiywail
- Banco de dados: Postgresql

# Como executar o projeto

## Back end
Pré-requisitos: Java 17 +

```bash
# clonar repositório
git clone https://github.com/HenriqueSilvaIt/ProjectListaDeJogosJPA.git

# entrar na pasta do projeto back end
cd DslistApplication

# executar o projeto
./mvnw spring-boot:run
```

## Trechos de código

### Plug-in Maven

```xml
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>


        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
```
### application.properties
```
spring.profiles.active=${APP_PROFILE:test}
spring.jpa.open-in-view=false

cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
```
### application-prod.properties

```
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```
### application-dev.properties

```
#spring.jpa.properties.jakarta.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=1234

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

# Autor

Henrique Oliveira da Silva

https://www.linkedin.com/in/henriqueoliveirati/

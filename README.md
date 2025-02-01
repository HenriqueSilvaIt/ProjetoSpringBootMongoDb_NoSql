# Rede Social
[![NPM](https://img.shields.io/badge/licence-MIT-blue)](https://github.com/HenriqueSilvaIt/ProjetoSpringBootMongoDb_NoSql/blob/main/LICENSE) 

# Sobre o projeto

Rede Social é uma aplicação back-end criada em uma aula da [DevSuperior](https://devsuperior.com "Site da DevSuperior").
É uma aplicação back-end que funciona como uma rede-social porém trabalha somente com
postagem e comentários e não com chats.
A aplicação utiliza o banco de dados NoSQl MongoDb, lingugagem orientada a agregados.

## Modelo Conceitual
![Modelo Domínio](https://github.com/HenriqueSilvaIt/Assets/blob/main/MongoDbProject/Modelo%20Conceitual.png) 

### Relacionamento entre objetos

![Objects](https://github.com/HenriqueSilvaIt/Assets/blob/main/MongoDbProject/Relacionamento%20entre%20objetos.png)

## Como funciona aplicação:

### Agregados do banco de dados

![Banco](https://github.com/HenriqueSilvaIt/Assets/blob/main/MongoDbProject/Banco%20MongoD.png)

### Usuários da rede

![Users](https://github.com/HenriqueSilvaIt/Assets/blob/main/MongoDbProject/Agregado%20usu%C3%A1rio.png)

### Postagens e comentários

![Post](https://github.com/HenriqueSilvaIt/Assets/blob/main/MongoDbProject/postagem%20com%20coment%C3%A1rios.png)

# Tecnologias utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Banco de dados: MongoDb

# Como executar o projeto

Pré-requisitos: Java 17 +

```bash
# clonar repositório
git clone https://github.com/HenriqueSilvaIt/ProjetoSpringBootMongoDb_NoSql.git

# entrar na pasta do projeto back end
cd ProjetoSpringBootMongoDb_NoSql

# Conectar ao mongodb
- mongod --bind_ip seuip

# executar o projeto
./mvnw spring-boot:run
```

## Trechos de código

### Plug-in Maven

 <dependencies>
  
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
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>

        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
    </dependencies>
```
### application-prod.properties

```
spring.data.mongodb.host=seuhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=workshop_mongo
```

# Autor

Henrique Oliveira da Silva

https://www.linkedin.com/in/henriqueoliveirati/

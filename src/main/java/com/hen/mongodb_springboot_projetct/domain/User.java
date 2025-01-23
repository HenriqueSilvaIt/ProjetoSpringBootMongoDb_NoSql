package com.hen.mongodb_springboot_projetct.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection="user") // Para dizer quessa classe corresponde a uma coleção do NOSQL MONGODb
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id // Chave primária
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true) // DBRef é utilizado para referenciar atributos no banco
    // em um agregado, o lazy = true
    // é para que o objeto abaixo só vai ser instanciado se eu acessar ele
    // então quando eu chamar o agregado do objeto usuário
    // ele n vai trazer direto a referencia do post
    private List<Post> posts = new ArrayList<>();
    // list é uma interface e o ArrayList é uma implementação possivel dessa lista

    // Construtores

    public User() {

    }
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Get and se
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Post> getPosts() {
        return posts;
    }

    //hashCode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //
}

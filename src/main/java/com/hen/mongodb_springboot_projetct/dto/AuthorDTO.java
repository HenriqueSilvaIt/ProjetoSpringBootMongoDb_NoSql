package com.hen.mongodb_springboot_projetct.dto;

import com.hen.mongodb_springboot_projetct.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    // Construtor
    public AuthorDTO () {

    }
    public AuthorDTO (User obj) {
        id = obj.getId();
        name = obj.getName();
    }

    //Get e set

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
}

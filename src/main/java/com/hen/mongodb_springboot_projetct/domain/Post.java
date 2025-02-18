package com.hen.mongodb_springboot_projetct.domain;

import com.hen.mongodb_springboot_projetct.dto.AuthorDTO;
import com.hen.mongodb_springboot_projetct.dto.CommentDTO;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private AuthorDTO author;
    private Date date;
    private String title;
    private String body; // corpo do post

    // Associando comentários

    private List<CommentDTO> comments = new ArrayList<> ();



    public Post( ) {

    }
    public Post(String id, AuthorDTO author, Date date, String title, String body) {
        this.author = author;
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    // Get and sette
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id =  id;
    }
    public AuthorDTO getauthor() {
        return author;
    }
    public void setauthor(AuthorDTO author) {
        this.author = author;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public  String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<CommentDTO> getComments() {
        return comments;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    // Has


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

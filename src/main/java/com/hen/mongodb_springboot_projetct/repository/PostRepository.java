package com.hen.mongodb_springboot_projetct.repository;

import com.hen.mongodb_springboot_projetct.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


    // Fazer o spring montar a consulta abaixo
    List<Post> findByTitleContainingIgnoreCase(String text);
    // ignorecase tira o case sentitive
}

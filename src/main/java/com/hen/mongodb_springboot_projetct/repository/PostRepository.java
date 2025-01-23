package com.hen.mongodb_springboot_projetct.repository;

import com.hen.mongodb_springboot_projetct.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // <field> - campo que vou executar a busca
    // regex: ?0 representa o primeiro argumento do método, se fosse o 2º seria ?1
    // options - 'i' ele ignora casesentitv
    @Query("{ 'title': { $regex: ?0, $options: 'i'} }")
    // esse método pode colocar o nome que quiser como vai ser um método personalizado
       List<Post> encontreTitulo(String text);

    // Fazer o spring montar a consulta abaixo
    List<Post> findByTitleContainingIgnoreCase(String text);
    // ignorecase tira o case sentitive
}

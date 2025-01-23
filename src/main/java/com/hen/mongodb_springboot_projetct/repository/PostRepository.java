package com.hen.mongodb_springboot_projetct.repository;

import com.hen.mongodb_springboot_projetct.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    // Fazer consulta por  um String em todo agregado
    //https://www.mongodb.com/pt-br/docs/manual/reference/operator/query/lte/
    // estamos dizendo que a data é maior que o parametro 1 que é a data min do objeto
    // gte (grather than or equal), lte less than or equal ( maior ou igual
    @Query("{ $and: [ {date: {$gte: ?1}  }, { date: { $lte: ?2 } } , { $or: [ {'title': { $regex: ?0, $options: 'i'} }, {'body': { $regex: ?0, $options: 'i'} },{'comments.text': { $regex: ?0, $options: 'i'} } ] }\n" +
            "\n] }\n" +
            "\n")
    // na ultima expressão acima é 3 condiçã ose pertence ao tititulo, ao corpo ou ao comentário
    // o body é sócolocar body que já pega, só que o comments tem que colocar commentents.text, porque text é
    // o atributo do CommentsDTO que tem o texto
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}

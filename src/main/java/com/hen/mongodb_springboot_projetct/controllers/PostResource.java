package com.hen.mongodb_springboot_projetct.controllers;

import com.hen.mongodb_springboot_projetct.domain.Post;
import com.hen.mongodb_springboot_projetct.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired // conectando a camada de resource( api) com a camada de serviço
    private PostService  postService;




    // Retorna usuário por Id
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);

    }

}

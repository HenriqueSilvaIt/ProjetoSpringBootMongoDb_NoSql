package com.hen.mongodb_springboot_projetct.controllers;

import com.hen.mongodb_springboot_projetct.controllers.util.URL;
import com.hen.mongodb_springboot_projetct.domain.Post;
import com.hen.mongodb_springboot_projetct.repository.UserRepository;
import com.hen.mongodb_springboot_projetct.services.PostService;
import com.hen.mongodb_springboot_projetct.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired // conectando a camada de resource( api) com a camada de serviço
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    // Retorna usuário por Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);

    }

    // Busca post pelo titulo
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postService.encontreTitulo(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
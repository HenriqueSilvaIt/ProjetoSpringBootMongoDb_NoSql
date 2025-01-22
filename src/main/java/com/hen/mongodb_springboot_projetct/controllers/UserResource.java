package com.hen.mongodb_springboot_projetct.controllers;

import com.hen.mongodb_springboot_projetct.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        User maria = new User("1", "maria", "maria@gmail.com");
        User alex = new User("2", "Alex Gren", "alex@gmail.com");
        List<User> list =  new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);// body é onde definimos qual
        // vai ser o corpo da reposta, e o .ok() quer dizer
        //que vai retornar ok o HTTP se for tudo com sucesso
    }

}

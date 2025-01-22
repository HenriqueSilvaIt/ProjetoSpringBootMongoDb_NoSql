package com.hen.mongodb_springboot_projetct.controllers;

import com.hen.mongodb_springboot_projetct.domain.User;
import com.hen.mongodb_springboot_projetct.dto.UserDTO;
import com.hen.mongodb_springboot_projetct.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired // conectando a camada de resource( api) com a camada de serviço
    private UserService userService;



    // pega todos os usuários da tabela
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        List<User> list = userService.findAll();
        // Convertendo o objeto da lista orinal acima para lista DTO:
        List<UserDTO> listDTO = list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
        // da forma acima eu busco a lista no banco de dados
        // e retorno a lista de usuários do banco
        return ResponseEntity.ok().body(listDTO);// body é onde definimos qual
        // vai ser o corpo da reposta, e o .ok() quer dizer
        //que vai retornar ok o HTTP se for tudo com sucesso
    }

    @RequestMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        User user = userService.findById(id);
        return ResponseEntity.ok().body( new UserDTO(user));

    }

}

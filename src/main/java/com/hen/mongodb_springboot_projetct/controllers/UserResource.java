package com.hen.mongodb_springboot_projetct.controllers;

import com.hen.mongodb_springboot_projetct.domain.User;
import com.hen.mongodb_springboot_projetct.dto.UserDTO;
import com.hen.mongodb_springboot_projetct.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    // Retorna usuário por Id
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        User user = userService.findById(id);
        return ResponseEntity.ok().body( new UserDTO(user));

    }

    // Insere dados na tabela
    @PostMapping
    //@RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) { //Response Entity retorna resposta HTTP já formatada com possíveis erros
       User obj = userService.fromDTO(objDto); // Converte objeto DTO para USER
       obj = userService.insert(obj); // inserindo objeto no banco de dados

        // Retorna uma resposta vazia, porém vai ter um cabeçalho com URL
        // do novo recurso criado, para fazer isso utiliza o objeto URI abaixo
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
       return ResponseEntity.created(uri).build();
       // crated retorna o código http 201 que é código que representa
        // que foi criado um novo recurso
        // no postman o corpo da requisição vai vir vazia mas o header vai trazer
        // a localização (end oint) com o id do usário/valor que foi criado

    }

    //Deleta usuário por id
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<UserDTO> delete(@PathVariable String id) { //Response Entity retorna resposta HTTP já formatada com possíveis erros
        userService.delete(id);
        return ResponseEntity.noContent().build(); // como é uma operação
        // que n tem que retornar nada, só delet, utiliza o no content

    }

    // Atualizar - Update

    @PutMapping(value="/{id}")
    //@RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) { //Response Entity retorna resposta HTTP já formatada com possíveis erros

        User obj = userService.fromDTO(objDto); // Converte objeto DTO para USER
        obj.setId(id);
        obj = userService.update(obj); // inserindo objeto no banco de dados

        // Retorna uma resposta vazia, porém vai ter um cabeçalho com URL
        // do novo recurso criado, para fazer isso utiliza o objeto URI abaixo
        return ResponseEntity.noContent().build();


    }

}

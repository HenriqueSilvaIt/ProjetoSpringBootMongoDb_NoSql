package com.hen.mongodb_springboot_projetct.services;

import com.hen.mongodb_springboot_projetct.domain.Post;
import com.hen.mongodb_springboot_projetct.repository.PostRepository;
import com.hen.mongodb_springboot_projetct.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {


    //Associação do service com o repostory (banco de dados)
    @Autowired // Injeção de dependência automática, faz a instanciação do objeto para nós
    private PostRepository userRepository;


    // Retorna usuário por ID
    public Post findById(String id) {
        Optional<Post> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); // isso quer dizer que  o usuário foi encontrado só retornar
    }

}

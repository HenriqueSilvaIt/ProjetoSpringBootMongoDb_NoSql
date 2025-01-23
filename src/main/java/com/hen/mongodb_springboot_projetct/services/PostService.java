package com.hen.mongodb_springboot_projetct.services;

import com.hen.mongodb_springboot_projetct.domain.Post;
import com.hen.mongodb_springboot_projetct.repository.PostRepository;
import com.hen.mongodb_springboot_projetct.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    /*// Método de buscsa FindByTitle
    public List<Post> findByTitle(String text) {
        return userRepository.findByTitleContainingIgnoreCase(text);
        // ignorecase tira o case sentitive
    }*/

    // Método de buscsa FindByTitle
    public List<Post> encontreTitulo(String text) {
        return userRepository.findByTitleContainingIgnoreCase(text);
        // ignorecase tira o case sentitive
    }

    // Método de consulta por texto no agregado
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 *60 * 1000);// 24hrs em milisegundo para pegar á 00:00 do dia seguinte
      return userRepository.fullSearch(text, minDate, maxDate);
    }

}

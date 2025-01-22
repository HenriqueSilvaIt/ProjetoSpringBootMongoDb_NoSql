package com.hen.mongodb_springboot_projetct.services;

import com.hen.mongodb_springboot_projetct.domain.User;
import com.hen.mongodb_springboot_projetct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    //Associação do service com o repostory (banco de dados)
    @Autowired // Injeção de dependência automática, faz a instanciação do objeto para nós
    private UserRepository userRepository;

    // Método responsável por retornar todos os usuários do banco de dados
    public List<User> findAll() {
        return userRepository.findAll(); // busca no banco todos usuários da tabela
        // que está declarada na lista acima User

    }
}

package com.hen.mongodb_springboot_projetct.services;

import com.hen.mongodb_springboot_projetct.domain.User;
import com.hen.mongodb_springboot_projetct.dto.UserDTO;
import com.hen.mongodb_springboot_projetct.repository.UserRepository;
import com.hen.mongodb_springboot_projetct.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Retorna usuário por ID
    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); // isso quer dizer que  o usuário foi encontrado só retornar
    }

    //  Inserir usuário na tabela
    public User insert(User user) {
        return userRepository.insert(user);
    }

    //Retorna o usuário da classe DTO (classe que deixa os dados consolidado)
    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}

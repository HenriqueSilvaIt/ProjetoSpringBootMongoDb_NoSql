package com.hen.mongodb_springboot_projetct.config;

import com.hen.mongodb_springboot_projetct.domain.Post;
import com.hen.mongodb_springboot_projetct.domain.User;
import com.hen.mongodb_springboot_projetct.dto.AuthorDTO;
import com.hen.mongodb_springboot_projetct.dto.CommentDTO;
import com.hen.mongodb_springboot_projetct.repository.PostRepository;
import com.hen.mongodb_springboot_projetct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration // para o spring entender que isso é uma configuração
public class Instatiation implements CommandLineRunner {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); // vai limpar a coleção de usuários no mongodb
        postRepository.deleteAll();

        // Criação de usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        //Salvando usuário
        userRepository.saveAll(Arrays.asList(maria, alex, bob)); // primeiro salvamos o
        // usuário no banco por isso o  save tem que estar antes do post
        // pois depois vamos associar esse id que foi criado no banco
        // ao AuthorDTO

        // Criação de post
        Post post1 = new Post(null, new AuthorDTO(maria), sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo!");
        Post post2 = new Post(null, new AuthorDTO(maria), sdf.parse("23/04/2018"), "Bom dia", "Acordei agora");
        // no caso acima de vez fazermos a injeção de dependencia de AuthorDTO
        // nós insciamos o objeto AuthoDTO e pasamos o usuário
        // como argumento, pois esse construtor espera um objeto como argumento

        // Comentários antes de salva post
        CommentDTO cm1 = new CommentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(maria));
        CommentDTO cm2 = new CommentDTO("Aproveite", sdf.parse("22/04/2024"), new AuthorDTO(bob));
        CommentDTO cm3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("24/03/2018"), new AuthorDTO(alex));

        //Associando post aos comentários
        post1.getComments().addAll(Arrays.asList(cm1,cm2));
        post2.getComments().addAll(Arrays.asList(cm3));
        // Salvando post
        postRepository.saveAll(Arrays.asList(post1, post2));

        // Lista de posts da maria
        maria.getPosts().addAll(Arrays.asList(post1, post2));

        // salvando postagem da maria
        userRepository.save(maria);
    }
}

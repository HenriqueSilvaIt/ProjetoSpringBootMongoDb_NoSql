package com.hen.mongodb_springboot_projetct.config;

import com.hen.mongodb_springboot_projetct.domain.Post;
import com.hen.mongodb_springboot_projetct.domain.User;
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

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, maria, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo!");
        Post post2 = new Post(null, maria, sdf.parse("23/04/2018"), "Bom dia", "Acordei agora");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}

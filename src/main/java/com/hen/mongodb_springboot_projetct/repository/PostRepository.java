package com.hen.mongodb_springboot_projetct.repository;

import com.hen.mongodb_springboot_projetct.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}

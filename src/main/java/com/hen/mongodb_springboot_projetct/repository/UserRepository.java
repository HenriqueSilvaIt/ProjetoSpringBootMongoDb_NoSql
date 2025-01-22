package com.hen.mongodb_springboot_projetct.repository;

import com.hen.mongodb_springboot_projetct.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

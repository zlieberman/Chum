package com.zlieberman.chum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zlieberman.chum.model.ChumUser;

public interface UserRepository extends MongoRepository<ChumUser, String> {

}

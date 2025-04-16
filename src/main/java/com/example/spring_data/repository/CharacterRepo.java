package com.example.spring_data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_data.model.Character;


@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {

}

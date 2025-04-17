package com.example.spring_data.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.spring_data.repository.CharacterRepo;
import com.example.spring_data.dto.CharacterDTO;
import com.example.spring_data.model.Character;


@Service
public class CharacterService {
    private final CharacterRepo repo;

    public CharacterService(CharacterRepo repo) {
        this.repo = repo;
    }

    public List<Character> getAllCharacters() {
        return repo.findAll();
    }

    public Character getCharacterByID(String id) {
        return repo.findById(id).orElseThrow(null);
    }

    public Character getCharacterByName(String name) {
        return repo.findAll().stream().filter(c -> c.name().equals(name)).findFirst().get();
    }

    public Character addCharacter(CharacterDTO character) {
        Character newCharacter = new Character(
            UUID.randomUUID().toString(), 
            character.name(),
            character.age(),
            character.profession()
        );
        
        repo.save(newCharacter);
        return newCharacter;
    }

    public void deleteCharacterByID(String id) {
        repo.deleteById(id);
    }
}

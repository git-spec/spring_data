package com.example.spring_data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_data.repository.CharacterRepo;
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

    // public Character getCharacterByName(@RequestParam String name) {
    //     return repo.findBy(x -> x.characters.stream().filter(character -> character.name.equals(name)).getFirst());
    // }

    public Character addCharacter(Character character) {
        return repo.save(character);
    }

    public void deleteCharacterByID(String id) {
        repo.deleteById(id);
    }
}

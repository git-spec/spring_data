package com.example.spring_data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_data.model.Character;
import com.example.spring_data.repository.CharacterRepo;


@RestController
@RequestMapping("api/abert_uderzo/characters")
public class CharacterController {
    private final CharacterRepo repo;

    public CharacterController(CharacterRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        // return List.of(
        //     new Character("1", "Asterix", 35, "Warrior"),
        //     new Character("2", "Obelix", 35, "Supplier"),
        //     new Character("3", "Miraculix", 60, "Druid"),
        //     new Character("4", "Majestix", 60, "Chief"),
        //     new Character("5", "Troubadix", 25, "Bard"),
        //     new Character("6", "Gutemine", 35, "Chiefs Wife"),
        //     new Character("7", "Idefix", 5, "Dog"),
        //     new Character("8", "Geriatrix", 70, "Retiree"),
        //     new Character("9", "Automatix", 35, "Smith"),
        //     new Character("10", "Grockelix", 35, "Fisherman")
        // );
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Character getCharacterByID(@PathVariable String id) {
        return repo.findById(id).orElseThrow(null);
    }

    @PostMapping
    public Character addCharacter(@RequestBody Character student) {
        return repo.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacterByID(@PathVariable String id) {
        repo.deleteById(id);
    }
}

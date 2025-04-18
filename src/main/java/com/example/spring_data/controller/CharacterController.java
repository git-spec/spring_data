package com.example.spring_data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_data.dto.CharacterDTO;
import com.example.spring_data.model.Character;
import com.example.spring_data.service.CharacterService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("api/abert_uderzo")
@AllArgsConstructor
public class CharacterController {
    CharacterService service;

    @GetMapping("/characters")
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
        return service.getAllCharacters();
    }

    @GetMapping("/characters/age/average")
    public int getAverageAgeOfCharacters() {
        return service.getAverageAgeOfCharacters();
    }

    @GetMapping("/character/{id}")
    public Character getCharacterByID(@PathVariable String id) {
        return service.getCharacterByID(id);
    }

    @GetMapping(value = "/character", params = "name")
    public Character getCharacterByName(@RequestParam("name") String name) {
        return service.getCharacterByName(name);
    }

    @GetMapping(value = "/characters", params = "role")
    public List<Character> getCharactersByRole(@RequestParam("role") String role) {
        return service.getCharactersByRole(role);
    }

    @GetMapping(value = "/characters/age/average", params = "role")
    public int getAverageAgeOfCharactersByRole(@RequestParam("role") String role) {
        return service.getAverageAgeOfCharactersByRole(role);
    }

    @PostMapping("/character")
    public Character addCharacter(@RequestBody CharacterDTO character) {
        return service.addCharacter(character);
    }

    @DeleteMapping("/character/{id}")
    public void deleteCharacterByID(@PathVariable String id) {
        service.deleteCharacterByID(id);
    }
}

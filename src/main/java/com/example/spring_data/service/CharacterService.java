package com.example.spring_data.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.spring_data.dto.CharacterDTO;
import com.example.spring_data.model.Character;
import com.example.spring_data.repository.CharacterRepo;


@Service
public class CharacterService {
    private final CharacterRepo repo;
    private final IDService idService;

    public CharacterService(CharacterRepo repo, IDService idService) {
        this.repo = repo;
        this.idService = idService;
    }

    private List<Character> findCharactersByRole(String role) {
        return repo
            .findAll()
            .stream()
            .filter(c -> c.role().toLowerCase().equals(role.toLowerCase()))
            .toList();
    }

    private int getAverage(List<Integer> list) {
        return list.stream().reduce(0, (age_1, age_2) -> age_1 + age_2) / list.size();
    }

    public List<Character> getAllCharacters() {
        return repo.findAll();
    }

    public int getAverageAgeOfCharacters() {
        List<Integer> ages = getAllCharacters()
            .stream()
            .map(c -> c.age())
            .collect(Collectors.toList());
        return getAverage(ages);
    }

    public Character getCharacterByID(String id) {
        return repo.findById(id).orElse(null);
    }

    public Character getCharacterByName(String name) {
        return repo
            .findAll()
            .stream()
            .filter(c -> c.name().equals(name))
            .findFirst()
            .get();
    }

    public List<Character> getCharactersByRole(String role) {
        return findCharactersByRole(role);
    }

    public int getAverageAgeOfCharactersByRole(String role) {
        List<Integer> ages = findCharactersByRole(role)
            .stream()
            .map(c -> c.age())
            .collect(Collectors.toList());
        return getAverage(ages);
    }

    public Character addCharacter(CharacterDTO character) {
        Character newCharacter = new Character(
            idService.createID(), 
            character.name(),
            character.age(),
            character.role()
        );
        
        repo.save(newCharacter);
        return newCharacter;
    }

    public void deleteCharacterByID(String id) {
        repo.deleteById(id);
    }
}

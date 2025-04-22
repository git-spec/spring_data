package com.example.spring_data.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.spring_data.dto.CharacterDTO;
import com.example.spring_data.repository.CharacterRepo;
import com.example.spring_data.model.Character;


public class CharacterServiceTest { 
    CharacterRepo mockRepo = mock(CharacterRepo.class);
    IDService mockID = mock(IDService.class);
    CharacterService service = new CharacterService(mockRepo, mockID);
    Character character = new Character("1", "Asterix", 35, "Warrior");
    CharacterDTO characterDTO = new CharacterDTO("Asterix", 35, "Warrior");

    @Test
    void testAddCharacter() {
        // GIVEN
        Optional<Character> response = Optional.of(character);
        Mockito.when(mockID.createID()).thenReturn("1");
        Mockito.when(mockRepo.findById("1")).thenReturn(response);
        // WHEN
        Character actual = service.addCharacter(characterDTO);
        // THEN
        assertEquals(response.get(), actual);
        Mockito.verify(mockRepo).save(actual);
    }

    @Test
    void testDeleteCharacterByID() {
        // GIVEN
        when(mockRepo.findById(character.id())).thenReturn(null);
        Character newCharacter = service.addCharacter(characterDTO);
        // WHEN
        service.deleteCharacterByID(newCharacter.id());
        // THEN
        assertNull(service.getCharacterByID(newCharacter.id()));
    }

    @Test
    void testGetAllCharacters() {

    }

    @Test
    void testGetAverageAgeOfCharacters() {

    }

    @Test
    void testGetAverageAgeOfCharactersByRole() {

    }

    @Test
    void testGetCharacterByID() {
        // GIVEN
        Optional<Character> response = Optional.of(character);
        when(mockRepo.findById(character.id())).thenReturn(response);
        // WHEN
        Character actual = service.getCharacterByID("1");
        // THEN
        assertEquals(response.get(), actual);
    }

    @Test
    void testGetCharacterByName() {

    }

    @Test
    void testGetCharactersByRole() {

    }
}

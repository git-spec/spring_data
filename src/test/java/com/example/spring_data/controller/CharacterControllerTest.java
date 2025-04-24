package com.example.spring_data.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;

import org.junit.jupiter.api.Test;

import com.example.spring_data.repository.CharacterRepo;
import com.example.spring_data.model.Character;


@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CharacterRepo repo;

    @Test
    void getAllCharacters_shouldReturnListOfCharacters_whenCalled() throws Exception {
        // GIVEN
        Character character = new Character("1", "Asterix", 35, "Warrior");
        repo.save(character);
        // WHEN
        mockMvc.perform(get("/api/abert_uderzo/characters"))
            // THEN
            .andExpect(status().isOk())
            .andExpect(content().json(
                """
                [
                    {
                        "id": "1",
                        "name": "Asterix",
                        "age": 35,
                        "role": "Warrior"
                    }
                ]
                """
            ));
    }

    @Test
    void getCharacterByID_shouldReturnCharacter_whenCalledWithID() throws Exception {
        // GIVEN
        Character character = new Character("1", "Asterix", 35, "Warrior");
        repo.save(character);
        // WHEN & THEN 
        mockMvc.perform(get("/api/abert_uderzo/character/{id}", "1"))
        .andExpect(status().isOk())
        .andExpect(content().json(
            """
            {
                "id": "1",
                "name": "Asterix",
                "age": 35,
                "role": "Warrior"
            }
            """
        ));
    }

    @Test
    void addCharacter_shouldReturnCharacter_whenCalledWithData() throws Exception {
        mockMvc.perform(post("/api/abert_uderzo/character")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                """
                    {
                        "name": "Asterix",
                        "age": 35,
                        "role": "Warrior"
                    }
                """
                )
            )
            .andExpect(status().isOk())
            .andExpect(content().json(
                """
                    {
                        "name": "Asterix",
                        "age": 35,
                        "role": "Warrior"
                    }
                """
            ))
            .andExpect(jsonPath("$.id").isNotEmpty());    // Checks path variable.
    }
}

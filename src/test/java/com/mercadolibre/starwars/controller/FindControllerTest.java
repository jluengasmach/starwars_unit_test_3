package com.mercadolibre.starwars.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

  @Mock
  FindService findService;

  @InjectMocks
  FindController findController;

  @Test
  void findMatchOk1() {
    // ARRANGE
      String param = "Luke";
      CharacterDTO expectedCharacter = new CharacterDTO();
      expectedCharacter.setName("Luke Skywalker");
      expectedCharacter.setHeight(172);
      expectedCharacter.setMass(77);
      expectedCharacter.setHair_color("blond");
      expectedCharacter.setSkin_color("fair");
      expectedCharacter.setEye_color("blue");
      expectedCharacter.setBirth_year("19BBY");
      expectedCharacter.setGender("male");
      expectedCharacter.setHomeworld("Tatooine");
      expectedCharacter.setSpecies("Human");
      List<CharacterDTO> expected = new ArrayList<>(List.of(expectedCharacter));

    // ACT
    Mockito.when(findService.find(param)).thenReturn(expected);

    List<CharacterDTO> result = findController.find(param);

    // ASSERT

    assertEquals(expected, result);
  }

  @Test
  void findMatchOk2() {
    // ARRANGE
    String param = "Darth";

    CharacterDTO expectedCharacter1 = new CharacterDTO();
    expectedCharacter1.setName("Darth Vader");
    expectedCharacter1.setHeight(202);
    expectedCharacter1.setMass(136);
    expectedCharacter1.setHair_color("none");
    expectedCharacter1.setSkin_color("white");
    expectedCharacter1.setEye_color("yellow");
    expectedCharacter1.setBirth_year("41.9BBY");
    expectedCharacter1.setGender("male");
    expectedCharacter1.setHomeworld("Tatooine");
    expectedCharacter1.setSpecies("Human");

    CharacterDTO expectedCharacter2 = new CharacterDTO();
    expectedCharacter2.setName("Darth Maul");
    expectedCharacter2.setHeight(175);
    expectedCharacter2.setMass(80);
    expectedCharacter2.setHair_color("none");
    expectedCharacter2.setSkin_color("red");
    expectedCharacter2.setEye_color("yellow");
    expectedCharacter2.setBirth_year("54BBY");
    expectedCharacter2.setGender("male");
    expectedCharacter2.setHomeworld("Dathomir");
    expectedCharacter2.setSpecies("Zabrak");
    List<CharacterDTO> expected = new ArrayList<>(List.of(expectedCharacter1, expectedCharacter2));

    // ACT
    Mockito.when(findService.find(param)).thenReturn(expected);
    List<CharacterDTO> result = findController.find(param);

    // ASSERT
    assertEquals(expected, result);
  }

  @Test
  void findMatchEmpty() {
    // ARRANGE
    String param = "asdf";
    List<CharacterDTO> expected = new ArrayList<>();
    // ACT
    Mockito.when(findService.find(param)).thenReturn(expected);
    List<CharacterDTO> result = findController.find(param);

    // ASSERT
    assertEquals(expected, result);
  }
}
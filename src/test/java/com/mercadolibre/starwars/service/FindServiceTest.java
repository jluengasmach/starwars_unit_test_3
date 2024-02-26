package com.mercadolibre.starwars.service;

import static org.junit.jupiter.api.Assertions.*;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
  CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
  FindService findService = new FindService(characterRepository);

  @Test
  void findOk() {
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
    List<CharacterDTO> result = findService.find(param);

    // ASSERT
    assertEquals(expected, result);
  }
}
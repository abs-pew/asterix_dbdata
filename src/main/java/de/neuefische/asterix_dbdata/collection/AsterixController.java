package de.neuefische.asterix_dbdata.collection;

import de.neuefische.asterix_dbdata.repository.CharacterRepository;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;
import de.neuefische.asterix_dbdata.model.Character;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
public class AsterixController {
   private final CharacterRepository characterRepo;

    public AsterixController(CharacterRepository characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping
   public List<Character> getAllCharacters() {
    return characterRepo.findAll();
   }

   @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return characterRepo.save(character);
   }

}

package de.neuefische.asterix_dbdata.collection;

import de.neuefische.asterix_dbdata.repository.CharacterRepository;
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

   @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
       return characterRepo.findById(id).get();
   }

   @PutMapping
    public Character updateCharacter(@RequestBody Character character) {
      Character retCharacter = characterRepo.findById(character.id()).orElse(null);
      retCharacter = character;
      return characterRepo.save(retCharacter);
   }

   @DeleteMapping
    public void deleteCharacterById(@RequestParam String id) {
        characterRepo.deleteById(id);
   }

   @GetMapping("/search")
    public List<Character> searchCharacters(@RequestParam String query) {
        return characterRepo.streamByNameContainsIgnoreCase(query);
   }
}

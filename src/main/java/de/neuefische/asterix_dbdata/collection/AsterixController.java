package de.neuefische.asterix_dbdata.collection;

import de.neuefische.asterix_dbdata.repository.CharacterRepository;
import de.neuefische.asterix_dbdata.service.CharacterService;
import org.springframework.web.bind.annotation.*;
import de.neuefische.asterix_dbdata.model.Character;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
public class AsterixController {
   private final CharacterService service;

    public AsterixController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
   public List<Character> getAllCharacters() {
    return service.getAllCharacters();
   }

   @PostMapping
    public Character addCharacter(@RequestBody Character character) {
        return service.addCharacter(character);
   }

   @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable String id) {
       return service.getCharacterById(id);
   }

   @PutMapping
    public Character updateCharacter(@RequestBody Character character) {
    return  service.updateCharacter(character);
   }

   @DeleteMapping
    public void deleteCharacterById(@RequestParam String id) {
        service.deleteCharacterById(id);
   }

   @GetMapping("/search")
    public List<Character> searchCharacters(@RequestParam String query) {
        return service.searchCharacters(query);
   }
}

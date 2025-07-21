package de.neuefische.asterix_dbdata.service;

import de.neuefische.asterix_dbdata.model.Character;
import de.neuefische.asterix_dbdata.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository repo;

    public CharacterService(CharacterRepository repo) {
        this.repo = repo;
    }

    public List<Character> getAllCharacters() {
        return repo.findAll();
    }

    public Character addCharacter(Character character) {
        return repo.save(character);
    }

    public Character getCharacterById(String id) {
        return repo.findById(id).get();
    }

    public Character updateCharacter(Character character) {
        Character retCharacter = repo.findById(character.id()).orElse(null);
        retCharacter = character;
        return repo.save(retCharacter);
    }

    public void deleteCharacterById(String id) {
        repo.deleteById(id);
    }

    public List<Character> searchCharacters(String query) {
        return repo.streamByNameContainsIgnoreCase(query);
    }
}

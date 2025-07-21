package de.neuefische.asterix_dbdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import de.neuefische.asterix_dbdata.model.Character;

import java.util.List;

@Repository
public interface CharacterRepository extends MongoRepository<Character,String> {

    List<Character> streamByNameEqualsIgnoreCase(String name);

    List<Character> streamByNameContainsIgnoreCase(String name);
}

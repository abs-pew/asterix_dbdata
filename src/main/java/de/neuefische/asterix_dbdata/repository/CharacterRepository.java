package de.neuefische.asterix_dbdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import de.neuefische.asterix_dbdata.model.Character;

@Repository
public interface CharacterRepository extends MongoRepository<Character,String> {

}

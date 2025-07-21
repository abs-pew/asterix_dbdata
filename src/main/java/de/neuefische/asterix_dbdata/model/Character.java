package de.neuefische.asterix_dbdata.model;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("Characters")
public record Character(
        String id,
        String name,
        int age,
        String profession) {
}

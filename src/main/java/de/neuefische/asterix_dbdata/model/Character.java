package de.neuefische.asterix_dbdata.model;

import org.springframework.data.mongodb.core.mapping.Document;


public record Character(
        String id,
        String name,
        int age,
        String profession) {
}

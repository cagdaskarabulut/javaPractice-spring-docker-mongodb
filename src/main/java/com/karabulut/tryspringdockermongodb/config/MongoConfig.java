package com.karabulut.tryspringdockermongodb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.karabulut.tryspringdockermongodb.model.Note;
import com.karabulut.tryspringdockermongodb.repository.NoteRepository;

@EnableMongoRepositories(basePackageClasses = NoteRepository.class)
@Configuration
public class MongoConfig {
	@Bean
    CommandLineRunner commandLineRunner(NoteRepository noteRepository) {
        return strings -> {
        	noteRepository.save(new Note(1, "Calvin", "Ryan"));
        	noteRepository.save(new Note(2, "Bryson", "Reid"));
        };
    }
}

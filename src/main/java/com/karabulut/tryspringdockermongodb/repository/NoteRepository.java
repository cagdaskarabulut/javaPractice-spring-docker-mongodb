package com.karabulut.tryspringdockermongodb.repository;

import com.karabulut.tryspringdockermongodb.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, Integer> {
}
package com.karabulut.tryspringdockermongodb.controller;

import com.karabulut.tryspringdockermongodb.model.Note;
import com.karabulut.tryspringdockermongodb.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/note")
@Validated
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @PostMapping("/")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteRepository.save(note));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getNotes() {
        return ResponseEntity.ok(noteRepository.findAll());
    }
}

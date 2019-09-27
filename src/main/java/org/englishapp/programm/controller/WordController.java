package org.englishapp.programm.controller;

import lombok.RequiredArgsConstructor;
import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    @GetMapping("/list")
    public ResponseEntity<List<Word>> findAll(){

        List<Word> words = wordService.findAll();

        if (words.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            List<Word> wordsAfterCheck = new ArrayList<>(words);

            return new ResponseEntity<>(wordsAfterCheck, HttpStatus.FOUND);
        }
    }

    @GetMapping("/list/{wordId}")
    public ResponseEntity<Word> getWord(@PathVariable long wordId){ // @PathVariable - send parameter's request

        Word word = wordService.findById(wordId); //

        if (word == null){
            throw new RuntimeException("Word id not found - " + wordId);
        }

        return new ResponseEntity<>(word, HttpStatus.FOUND);
    }

    @PostMapping("/list")
    public ResponseEntity<Word> addWord(@RequestBody Word word){

        wordService.save(word);

        return new ResponseEntity<>(word, HttpStatus.CREATED);
    }

    @PutMapping("/list")
    public ResponseEntity<Word> updateWord(@RequestBody Word word){

        wordService.save(word);

        return new ResponseEntity<>(word, HttpStatus.OK);
    }

    @DeleteMapping("/list/{wordId}")
    public ResponseEntity<String> deleteWord(@PathVariable long wordId){

        Word word = wordService.findById(wordId);

        if (word == null){
            throw new RuntimeException("Category id not found - " + wordId);
        }

        wordService.deleteById(wordId);

//        return "Deleted word id - " + wordId;
        return new ResponseEntity<>("Deleted word id " + wordId,HttpStatus.OK);
    }

}

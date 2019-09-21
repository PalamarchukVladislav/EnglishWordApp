package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/word")
public class WordController {

    private WordService wordService;


    WordController(WordService wordService){
        this.wordService = wordService;
    } // Dependency injection

    @GetMapping("/list")
    public List<Word> findAll(){
        return wordService.findAll();
    } // send request to wordService to find all word.

    @GetMapping("/list/{wordId}")
    public Word getWord(@PathVariable long wordId){ // @PathVariable - send parameter's request

        Word word = wordService.findById(wordId); //

        if (word == null){
            throw new RuntimeException("Word id not found - " + wordId);
        }

        return word;
    }

    @PostMapping("/list")
    public Word addWord(@RequestBody Word word){

        wordService.save(word);

        return word;
    }

    @PutMapping("/list")
    public Word updateWord(@RequestBody Word word){

        wordService.save(word);

        return word;
    }

    @DeleteMapping("/list/{wordId}")
    public String deleteWord(@PathVariable long wordId){

        Word word = wordService.findById(wordId);

        if (word == null){
            throw new RuntimeException("Category id not found - " + wordId);
        }

        wordService.deleteById(wordId);

        return "Deleted word id - " + wordId;
    }

}

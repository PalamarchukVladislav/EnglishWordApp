package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;
import org.englishapp.programm.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/word")
public class WordController {

    private WordService wordService;

    WordController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping("/list")
    public List<Word> findAll(){

        return wordService.findAll();
    }

    @GetMapping("/list/{wordId}")
    public Word getWord(@PathVariable long wordId){

        Word word = wordService.findById(wordId);

        if (word == null){
            throw new RuntimeException("Word id not found - " + wordId);
        }

        return word;
    }

    @PostMapping("/list")
    public WordRequest addWord(@RequestBody WordRequest wordRequest){

        wordService.save(wordRequest);

        return wordRequest;
    }

    @PutMapping("/list")
    public WordRequest updateWord(@RequestBody WordRequest wordRequest){

        wordService.save(wordRequest);

        return wordRequest;
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

package org.englishapp.programm.controller;

import org.englishapp.programm.model.entity.Word;
import org.englishapp.programm.model.entity.request.WordRequest;
import org.englishapp.programm.model.entity.response.WordResponse;
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
    public WordResponse getWord(@PathVariable long wordId){ // @PathVariable - send parameter's request

        WordResponse wordResponse = wordService.findById(wordId);

        if (wordResponse == null){
            throw new RuntimeException("Word id not found - " + wordId);
        }

        return wordResponse;
    }

    @PostMapping("/list")
    public WordResponse addWord(@RequestBody WordRequest wordRequest){

        wordService.save(wordRequest);

        return wordService.save(wordRequest);
    }

    @PutMapping("/list")
    public WordResponse updateWord(@RequestBody WordRequest wordRequest){

        wordService.save(wordRequest);

        return wordService.save(wordRequest);
    }

    @DeleteMapping("/list/{wordId}")
    public String deleteWord(@PathVariable long wordId){

        WordResponse wordResponse = wordService.findById(wordId);

        if (wordResponse == null){
            throw new RuntimeException("Category id not found - " + wordId);
        }

        wordService.deleteById(wordId);

        return "Deleted word id - " + wordId;
    }

}

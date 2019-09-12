package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Word;
import com.luv2code.springboot.cruddemo.service.WordService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/word")
public class WordController {

    private WordService wordService;

    public WordController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping("/list")
    public List<Word> findAll(Model model){

        // get employees from db
        List<Word> categories = wordService.findAll();

        // add to the spring model
        model.addAttribute("word", categories);


        return wordService.findAll();
    }

    @GetMapping("/list/{wordId}")
    public Word getWord(@PathVariable int wordId){

        Word word = wordService.findById(wordId);

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
    public String deleteWord(@PathVariable int wordId){

        Word word = wordService.findById(wordId);

        if (word == null){
            throw new RuntimeException("Category id not found - " + wordId);
        }

        wordService.deleteById(wordId);

        return "Deleted word id - " + wordId;
    }

}

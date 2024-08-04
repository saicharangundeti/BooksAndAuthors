package com.BooksAndAuthorsManagement.controller;
import com.BooksAndAuthorsManagement.Service.AuthorService;
import com.BooksAndAuthorsManagement.model.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Author> getAnAuthor(@PathVariable int authorId){
        Author author = authorService.findAuthorById(authorId);
        if(author == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/authorsByName")
    public  ResponseEntity<Author> getAuthorByName(@RequestParam(value = "authorName", required = false) String authorName){
        if(authorService.findAuthorByName(authorName) != null){
            return ResponseEntity.ok(authorService.findAuthorByName(authorName));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }


    @PostMapping("/authors")
    public ResponseEntity<Author> postAuthor(@Valid @RequestBody Author author){
        if(authorService.saveAuthor(author) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(author);
    }


    @PutMapping("/authors/{authorId}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        if(authorService.updateAuthor(author) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(author);
    }


    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable int authorId){
        if(authorService.deleteAuthorById(authorId)){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
}

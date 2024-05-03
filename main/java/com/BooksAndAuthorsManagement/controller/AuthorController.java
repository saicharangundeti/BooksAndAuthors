package com.BooksAndAuthorsManagement.controller;
import com.BooksAndAuthorsManagement.Service.AuthorService;
import com.BooksAndAuthorsManagement.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    static AuthorService authorService = new AuthorService();
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAnAuthor(@PathVariable String authorId){
        Author author = authorService.getAuthorById(authorId);
        if(author == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public static ResponseEntity<ArrayList<Author>> getAllAuthors(@RequestParam(value = "authorName", required = false) String authorName){
        if(authorName == null || authorName.equals("")){
            return ResponseEntity.ok(authorService.findAll());
        }
        else if(authorService.findAllAuthorByName(authorName).size() > 0){
            return ResponseEntity.ok(authorService.findAllAuthorByName(authorName));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }


    @PostMapping
    public static ResponseEntity<Author> postAuthor(@RequestBody Author author){
        if(authorService.saveAuthor(author) == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok(author);
    }


    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        if(authorService.updateAuthor(author) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(author);
    }


    @DeleteMapping("/{authorId}")
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable String authorId){
        if(authorService.deleteAuthorById(authorId) == true){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
}

package com.BooksAndAuthorsManagement.controller;
import com.BooksAndAuthorsManagement.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    static Map<String , Author> authorMap = new HashMap<>();
    @GetMapping("/authorId")
    public ResponseEntity<Author> getANAuthor(@PathVariable String authorId){
        if(authorMap.containsKey(authorId)){
            return ResponseEntity.ok(authorMap.get(authorId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public static ResponseEntity<ArrayList<Author>> getAllAuthors(@RequestParam(value = "authorName", required = false) String authorName){
        if(authorName == null || authorName.equals("")){
            ArrayList<Author> allAuthors = new ArrayList<>(authorMap.values());
            return ResponseEntity.ok(allAuthors);
        }else{
            ArrayList<Author> specificAuthors = new ArrayList<>();
            for(Author author: authorMap.values()){
                if(author.getName().equals(authorName)){
                    specificAuthors.add(author);
                }
            }
            if(specificAuthors.size() > 0) return ResponseEntity.ok(specificAuthors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PostMapping
    public static ResponseEntity<Author> postAuthor(@RequestBody Author author){
        if(author.getId() == null || authorMap.containsKey(author.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        authorMap.put(author.getId(),author);
        //check for author validations
        return ResponseEntity.ok(author);
    }
    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        if(authorMap.containsKey(author.getId())){
            Author update = authorMap.get(author.getId());
            update.setName(author.getName());
            return ResponseEntity.ok(update);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @DeleteMapping("/{authorId}")
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable String authorId){
        if(authorMap.containsKey(authorId)){
            authorMap.remove(authorId);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }


}

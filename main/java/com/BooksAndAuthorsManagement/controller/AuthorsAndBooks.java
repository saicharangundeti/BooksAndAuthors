package com.BooksAndAuthorsManagement.controller;


import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books-authors/v1")
public class AuthorsAndBooks {
    Map<String,Book> bookMap = new HashMap<>();
    Map<String , Author> authorMap = new HashMap<>();
    @GetMapping("/greet")
    public String greet(){
        return "Hello, this is my books and Authors api service";
    }
    @GetMapping("/books/bookId")
    public ResponseEntity<Book> getABook(@PathVariable String bookId){
        if(bookMap.containsKey(bookId)){
            return ResponseEntity.ok(bookMap.get(bookId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @GetMapping("/authors")
    public ResponseEntity<ArrayList<Author>> getAllAuthors(@RequestParam(value = "authorName",required = false) String authorName){
        if(authorName == null || authorName.equals("")){
            ArrayList<Author> allAuthors = new ArrayList<>(authorMap.values());
            return ResponseEntity.ok(allAuthors);
        }else{
            boolean isAuthorExist = false;
            ArrayList<Author> specificAuthors = new ArrayList<>();
            for(Author author: authorMap.values()){
                if(author.getAuthorName().equals(authorName)){
                    specificAuthors.add(author);
                    isAuthorExist = true;
                }
            }
            if(isAuthorExist == true) return ResponseEntity.ok(specificAuthors);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }
    @GetMapping("/books")
    public ResponseEntity<ArrayList<Book>> getAllBooks(@RequestParam(value = "bookName",required = false) String bookName){
        if(bookName == null || bookName.equals("")){
            ArrayList<Book> allBooks = new ArrayList<>(bookMap.values());
            return  ResponseEntity.ok(allBooks);
        } else{
            boolean isBookPresent = false;
            ArrayList<Book> specificBooks = new ArrayList<>();
            for(Book book : bookMap.values()){
                if(book.getBookName().equals(bookName)){
                    specificBooks.add(book);
                    isBookPresent = true;
                }
            }
            if(isBookPresent == true) return ResponseEntity.ok(specificBooks);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }
    @PostMapping("/books")
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        if(book.getBookId() == null || bookMap.containsKey(book.getBookId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        bookMap.put(book.getBookId(),book);
        authorMap.put(book.getAuthor().getAuthorId(),book.getAuthor());
        return ResponseEntity.ok(book);
    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(bookMap.containsKey(book.getBookId())){
            Book update = bookMap.get(book.getBookId());
            update.setBookName(book.getBookName());
            update.setAuthor(book.getAuthor());
            update.setNumberOfPages(book.getNumberOfPages());
            bookMap.put(book.getBookId(),update);
            return ResponseEntity.ok(update);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable String bookId){
        if(bookMap.containsKey(bookId)){
            bookMap.remove(bookId);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}

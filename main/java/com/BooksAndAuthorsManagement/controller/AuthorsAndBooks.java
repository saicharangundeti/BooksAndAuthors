package com.BooksAndAuthorsManagement.controller;


import com.BooksAndAuthorsManagement.BooksAndAuthorsManagementApplication;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books-authors/v1")
public class AuthorsAndBooks {
    Map<String,Book> books = new HashMap<>();
    @GetMapping("/greet")
    public String greet(){
        return "Hello, this is my books and Authors api service";
    }
    @GetMapping("/books/bookId")
    ResponseEntity<Book> getABook(@PathVariable String bookId){
        if(books.containsKey(bookId)){
            return ResponseEntity.ok(books.get(bookId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @GetMapping("/books")
    ResponseEntity<ArrayList<Book>> getAllBooks(){
        return  ResponseEntity.ok(new ArrayList(books.values()));
    }
    @PostMapping("/books")
    ResponseEntity<Book> postBook(@RequestBody Book book){
        if(book.getBookId() == null || books.containsKey(book.getBookId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        books.put(book.getBookId(),book);
        return ResponseEntity.ok(book);
    }
    @PutMapping("/books/{bookId}")
    ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(books.containsKey(book.getBookId())){
            Book update = books.get(book.getBookId());
            update.setBookName(book.getBookName());
            update.setAuthor(book.getAuthor());
            update.setNumberOfPages(book.getNumberOfPages());
            books.put(book.getBookId(),update);
            return ResponseEntity.ok(update);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
    @DeleteMapping("/books/{bookId}")
    ResponseEntity<Boolean> deleteBook(@PathVariable String bookId){
        if(books.containsKey(bookId)){
            books.remove(bookId);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}

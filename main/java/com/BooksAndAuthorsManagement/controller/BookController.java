package com.BooksAndAuthorsManagement.controller;

import com.BooksAndAuthorsManagement.Exeptions.CustomSQLExceptions;
import com.BooksAndAuthorsManagement.Service.BookService;
import com.BooksAndAuthorsManagement.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/v1")

public class BookController {

    @Autowired
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId){
        if(bookService.findBookById(bookId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(bookService.findBookById(bookId));
    }


    @GetMapping("/books/bookByName")
    public ResponseEntity<Book> getBookByName(@RequestParam(value = "bookName", required = false) String bookName) {

        if(bookService.findBookByName(bookName) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Book book = bookService.findBookByName(bookName);
        return ResponseEntity.ok(book);

    }


    @PostMapping("/books")
    public ResponseEntity<String> postBook(@Valid  @RequestBody Book book) {
        try {
            if (bookService.saveBook(book) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok("successfully posted");
        } catch (CustomSQLExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable int bookId,@RequestBody Book book){
        if(bookService.findBookById(bookId) == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Book updatedBook = bookService.updateBook(bookId, book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);

    }


    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable int bookId){
        if(bookService.deleteBook(bookId)){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}

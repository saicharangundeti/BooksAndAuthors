package com.BooksAndAuthorsManagement.controller;

import com.BooksAndAuthorsManagement.Service.BookService;
import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/books")

public class BookController {

    @Autowired
    private BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getABook(@PathVariable String bookId){
        if(bookService.findBookById(bookId) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(bookService.findBookById(bookId));
    }


    @GetMapping
    public ResponseEntity<ArrayList<Book>> getAllBooks(@RequestParam(value = "bookName", required = false) String bookName) {
        if (bookName == null || bookName.equals("")) {
            return ResponseEntity.ok(bookService.findAllBooks());
        } else if(bookService.findAllBooksbyName(bookName).size() > 0){
            return ResponseEntity.ok(bookService.findAllBooksbyName(bookName));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        if(bookService.saveBook(book) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok(book);
    }


    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(bookService.updateBook(book) == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(bookService.updateBook(book));
    }


    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable String bookId){
        if(bookService.removeBook(bookId)){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}

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
@RequestMapping("/v1/books")

public class BookController {

    @Autowired
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getABook(@PathVariable int bookId){
        if(bookService.findBookById(bookId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(bookService.findBookById(bookId));
    }


//    @GetMapping
//    public ResponseEntity<ArrayList<Book>> getAllBooks(@RequestParam(value = "bookName", required = false) String bookName) {
//        if (bookName == null || bookName.equals("")) {
//            return ResponseEntity.ok(bookService.findAllBooks());
//        } else if(bookService.findAllBooksByName(bookName).size() > 0){
//            return ResponseEntity.ok(bookService.findAllBooksByName(bookName));
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//    }


    @PostMapping("")
    public ResponseEntity<String> postBook(@Valid @RequestBody Book book) {
        try {
            if (bookService.saveBook(book) == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(book.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (CustomSQLExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(bookService.updateBook(book) != null )
            return ResponseEntity.ok(bookService.updateBook(book));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    }


    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable int bookId){
        if(bookService.deleteBook(bookId)){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}

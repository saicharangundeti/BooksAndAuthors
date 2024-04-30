package com.BooksAndAuthorsManagement.controller;

import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/books")

public class BookController {
    static Map<String, Book> bookMap = new HashMap<>();

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getABook(@PathVariable String bookId){
        if(bookMap.containsKey(bookId)){
            return ResponseEntity.ok(bookMap.get(bookId));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public static ResponseEntity<ArrayList<Book>> getAllBooks(@RequestParam(value = "bookName", required = false) String bookName) {
        if (bookName == null || bookName.equals("")) {
            ArrayList<Book> allBooks = new ArrayList<>(bookMap.values());
            return ResponseEntity.ok(allBooks);
        } else {
            ArrayList<Book> specificBooks = new ArrayList<>();
            for (Book book : bookMap.values()) {
                if (book.getBookName().equals(bookName)) {
                    specificBooks.add(book);
                }
            }
            if (specificBooks.size() > 0) return ResponseEntity.ok(specificBooks);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        if(book.getBookId() == null || bookMap.containsKey(book.getBookId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        bookMap.put(book.getBookId(),book);
        //check for author validations
        return ResponseEntity.ok(book);
    }
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(bookMap.containsKey(book.getBookId())){
            Book update = bookMap.get(book.getBookId());
            update.setBookName(book.getBookName());
            update.setAuthorId(book.getAuthorId());
            update.setNumberOfPages(book.getNumberOfPages());
            bookMap.put(book.getBookId(),update);
            return ResponseEntity.ok(update);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable String bookId){
        if(bookMap.containsKey(bookId)){
            bookMap.remove(bookId);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}

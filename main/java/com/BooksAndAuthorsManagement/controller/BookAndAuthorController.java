package com.BooksAndAuthorsManagement.controller;

import com.BooksAndAuthorsManagement.Service.AuthorService;
import com.BooksAndAuthorsManagement.Service.BookAndAuthorService;
import com.BooksAndAuthorsManagement.Service.BookService;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.model.BookAndAuthor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/booksAndAuthor")
public class BookAndAuthorController {
    BookAndAuthorService bookAndAuthorService;

    public BookAndAuthorController(BookAndAuthorService bookAndAuthorService){
        this.bookAndAuthorService = bookAndAuthorService;
    }
    @GetMapping("/greet")
    public String greeting(){
        return "Hello this is BookAndAuthor Controller";
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookAndAuthor> getBookDetails(@PathVariable int bookId){
        long startTime = System.currentTimeMillis();
        if(bookAndAuthorService.getBookDetails(bookId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        BookAndAuthor bookAndAuthor = bookAndAuthorService.getBookDetails(bookId);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time");
        System.out.println(endTime-startTime);
        return ResponseEntity.ok(bookAndAuthor);

    }


}

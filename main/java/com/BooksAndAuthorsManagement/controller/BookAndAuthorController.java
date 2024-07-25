package com.BooksAndAuthorsManagement.controller;

import com.BooksAndAuthorsManagement.Service.AuthorService;
import com.BooksAndAuthorsManagement.Service.BookService;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.model.BookAndAuthor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/booksAndAuthor")
public class BookAndAuthorController {
    BookService bookService;
    AuthorService authorService;

    public BookAndAuthorController(BookService bookService, AuthorService authorService){
        this.authorService = authorService;
        this.bookService = bookService;
    }
    @GetMapping("/greet")
    public String greeting(){
        return "Hello this is BookAndAuthor Controller";
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookAndAuthor> getBookDetails(@PathVariable int bookId){
        if(bookService.findBookById(bookId) != null){
            Book book = bookService.findBookById(bookId);
            Author author = authorService.getAuthorById(book.getAuthorId());
            BookAndAuthor bookAndAuthor = new BookAndAuthor(book,author);
            return ResponseEntity.ok(bookAndAuthor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}

package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.model.BookAndAuthor;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import com.BooksAndAuthorsManagement.Service.RelationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class BookAndAuthorService {
    private BookService bookService;
    private AuthorService authorService;
    private RelationService relationService;
    public BookAndAuthorService(BookService bookService, AuthorService authorService, RelationService relationService){
        this.bookService = bookService;
        this.authorService = authorService;
        this.relationService =  relationService;
    }
    public BookAndAuthor getBookDetails(int bookId){
        Book book = bookService.findBookById(bookId);
        if(book == null) {
            return null;
        }
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        Set<Integer> authorIds = relationService.findAuthorIds(bookId);
        book.setAuthors(authorIds);
        Set<Author> authors = new HashSet<>();
        for(int id : authorIds.stream().toList()){
            Author author = authorService.findAuthorById(id);
            if(author != null) {
                authors.add(author);
            }
        }
        bookAndAuthor.setBookId(bookId);
        bookAndAuthor.setBookName(book.getName());
        bookAndAuthor.setNumberOfPages(book.getNumberOfPages());
        bookAndAuthor.setAuthors(authors);
        return bookAndAuthor;
    }

}

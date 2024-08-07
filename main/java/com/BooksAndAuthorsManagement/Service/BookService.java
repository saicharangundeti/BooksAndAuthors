package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;


@Service
public class BookService {
    private  BookRepo bookRepo;
    private  RelationService relationService;
    private AuthorService authorService;

    public BookService(BookRepo bookRepo, RelationService relationRepo,AuthorService authorService){
        this.bookRepo = bookRepo;
        this.relationService = relationRepo;
        this.authorService = authorService;
    }
    public List<Book> findAllBooks(){
        List<Book> books = bookRepo.findAllBooks();
        for(Book book : books){
            book.setAuthors(relationService.findAuthorIds(book.getId()));
        }
        return books;
    }
    public Book findBookById(int id){
        if(bookRepo.getBookById(id) == null) {
            return null;
        }
        Book book = bookRepo.getBookById(id);
        book.setAuthors(relationService.findAuthorIds(id));
        return book;
    }
    public Book findBookByName( String name){
        if(bookRepo.getBookByName(name) == null){
            return null;
        }
        Book book = bookRepo.getBookByName(name);
        book.setAuthors(relationService.findAuthorIds(book.getId()));
        return book;
    }
    public Book saveBook(Book book) {
        if (bookRepo.getBookByName(book.getName()) != null) {
            return null;
        }
        boolean isAuthorIdExist = true;
        for (int id : book.getAuthorIds()) {
            if (authorService.findAuthorById(id) == null) {
                isAuthorIdExist = false;
            }
        }
        if (isAuthorIdExist) {
            bookRepo.saveBook(book);
            Book savedBook = bookRepo.getBookByName(book.getName());
            if (savedBook != null) {
                int bookId = savedBook.getId();
                relationService.saveBookIdAndAuthorIds(bookId, book.getAuthorIds());
            }
            return book;
        }
        return null;
    }
    public Book updateBook(int id, Book book){
       if(bookRepo.getBookById(id) == null){
           return null;
       }
       bookRepo.updateBook(id,book);
       relationService.deleteBookAndAuthor(id);
       relationService.saveBookIdAndAuthorIds(id,book.getAuthorIds());
       book.setAuthors(relationService.findAuthorIds(id));
       book.setId(id);
       return book;

    }
    public boolean deleteBook(int id){
        if(bookRepo.getBookById(id) == null){
            return false;
        }
        bookRepo.removeBook(id);
        relationService.deleteBookAndAuthor(id);
        return true;

    }
}


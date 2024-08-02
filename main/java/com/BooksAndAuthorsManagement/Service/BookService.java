package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import com.BooksAndAuthorsManagement.repo.RelationRepo;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookService {
    private  BookRepo bookRepo;
    private  RelationRepo relationRepo;
    private AuthorService authorService;

    public BookService(BookRepo bookRepo, RelationRepo relationRepo,AuthorService authorService){
        this.bookRepo = bookRepo;
        this.relationRepo = relationRepo;
        this.authorService = authorService;
    }
    public List<Book> findAllBooks(){
        List<Book> books = bookRepo.findAllBooks();
        for(Book book : books){
            book.setAuthors(relationRepo.getAuthorId(book.getId()));
        }
        return books;
    }
    public Book findBookById(int id){
        if(bookRepo.getBookById(id) == null) {
            return null;
        }
        Book book = bookRepo.getBookById(id);
        book.setAuthors(relationRepo.getAuthorId(id));
        return book;
    }
    public Book findBookByName( String name){
        if(bookRepo.getBookByName(name) == null){
            return null;
        }
        Book book = bookRepo.getBookByName(name);
        book.setAuthors(relationRepo.getAuthorId(book.getId()));
        return book;
    }
    public Book saveBook(Book book){
        boolean isExistBookId = true;
        for(int bookId : book.getAuthorIds()){
            if(authorService.getAuthorById(bookId) == null){
                isExistBookId = false;
            }
        }
        if(bookRepo.getBookByName(book.getName()) == null){
            if(isExistBookId) {
                bookRepo.saveBook(book);
                bookRepo.saveBookIdAndAuthorIdIntoRelation(book);
                book.setAuthors(relationRepo.getAuthorId(book.getId()));
                return book;
            }
            return null;
        }
        else if(isExistBookId) {
            bookRepo.saveBookIdAndAuthorIdIntoRelation(book);
            book.setAuthors(relationRepo.getAuthorId(book.getId()));
        }
        return null;
    }
    public Book updateBook(int id, Book book){
       if(bookRepo.getBookById(id) == null){
           return null;
       }
       bookRepo.updateBook(id,book);
       relationRepo.removeBookAndAuthor(id);
       relationRepo.updateBookIdAndAuthorId(id,book.getAuthorIds());
       book.setAuthors(relationRepo.getAuthorId(id));
       book.setId(id);
       return book;

    }
    public boolean deleteBook(int id){
        if(bookRepo.getBookById(id) == null){
            return false;
        }
        bookRepo.removeBook(id);
        relationRepo.removeBookAndAuthor(id);
        return true;

    }
}


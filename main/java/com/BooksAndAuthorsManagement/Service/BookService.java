package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookService {
    @Autowired
    private final BookRepo bookRepo;
    public BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }
    public List<Book> findAllBooks(){

        return bookRepo.findAllBooks();
    }
//    public ArrayList<Book> findAllBooksByName(String name){
//        return bookRepo.findAllBooksByName(name);
//    }
    public Book findBookById(int id){
        if(bookRepo.getBookById(id) == null){
            return null;
        }
        return bookRepo.getBookById(id);
    }
    public Book saveBook(Book book){
        if(bookRepo.getBookByName(book.getName()) == null){
            bookRepo.saveBook(book);
            bookRepo.saveBookAndAuthorIntoRelationTable(book);
            return book;
        };
        return null;
    }
    public Book updateBook(Book book){
       if(bookRepo.getBookById(book.getId()) == null){
           return null;
       }
       bookRepo.updateBook(book);
       bookRepo.updateBookIdAndAuthorIdInRelationTable(book);
       return book;

    }
    public boolean deleteBook(int id){
        if(bookRepo.getBookById(id) == null){
            return false;
        }
        bookRepo.removeBook(id);
        bookRepo.removeBookAndAuthorInRelationTable(id);
        return true;

    }
}


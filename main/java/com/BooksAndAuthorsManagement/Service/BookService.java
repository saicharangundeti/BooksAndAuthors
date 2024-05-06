package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }
    public ArrayList<Book> findAllBooks(){

        ArrayList<Book> allBooks = bookRepo.findAllBooks();
        return allBooks;
    }
    public ArrayList<Book> findAllBooksByName(String name){

        ArrayList<Book> specBooks = bookRepo.findAllBooksByName(name);
        return specBooks;
    }
    public Book findBookById(String id){
        Book reqBook = bookRepo.getBook(id);
        return reqBook;
    }
    public Book saveBook(Book book){
        Book savedBook = bookRepo.addBook(book);
        return savedBook;
    }
    public Book updateBook(Book book){
        Book updatedBook = bookRepo.updateBook(book);
        return updatedBook;

    }
    public boolean removeBook(String id){
        boolean isRemoved = bookRepo.removeBook(id);
        return isRemoved;
    }
}


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
    public ArrayList<Book> findAllBooks(){
        return bookRepo.findAllBooks();
    }
    public ArrayList<Book> findAllBooksbyName(String name){
        return bookRepo.findAllBooksbyName(name);
    }
    public Book findBookById(String id){
        return bookRepo.getBook(id);
    }
    public Book saveBook(Book book){
        return bookRepo.addBook(book);
    }
    public Book updateBook(Book book){
        return bookRepo.updateBook(book);

    }
    public boolean removeBook(String id){
        return bookRepo.removeBook(id);
    }
}

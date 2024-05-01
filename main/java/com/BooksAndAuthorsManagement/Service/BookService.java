package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    static Map<String, Book> bookMap = new HashMap<>();
    public ArrayList<Book> findAllBooks(){
        return new ArrayList<>(bookMap.values());
    }
    public ArrayList<Book> findAllBooksbyName(String name){
        ArrayList<Book> specBooks = new ArrayList<>();
        for(Book book : bookMap.values()){
            if(book.getBookName().equals(name)){
                specBooks.add(book);
            }
        }
        return specBooks;
    }
    public Book findBookById(String id){
        if(bookMap.containsKey(id)){
            return bookMap.get(id);
        }
        return null;
    }
    public Book saveBook(Book book){
        if(bookMap.containsKey(book.getBookId())){
            return null;
        }
        bookMap.put(book.getBookId(),book);
        return book;
    }
    public Book updateBook(Book book){
        if(bookMap.containsKey(book.getBookId())){
            Book updateBook = bookMap.get(book.getBookId());
            updateBook.setBookName(book.getBookName());
            updateBook.setNumberOfPages(book.getNumberOfPages());
            updateBook.setAuthorId(book.getAuthorId());
            return updateBook;
        }
        return null;
    }
    public boolean removeBook(String id){
        if(bookMap.containsKey(id)){
            bookMap.remove(id);
            return true;
        }
        return false;
    }
}

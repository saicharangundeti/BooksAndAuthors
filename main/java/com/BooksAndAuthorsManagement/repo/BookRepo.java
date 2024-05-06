package com.BooksAndAuthorsManagement.repo;

import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepo {
    private final Map<String , Book> bookMap = new HashMap<>();
    public ArrayList<Book> findAllBooks(){
        return new ArrayList<>(bookMap.values());
    }
    public ArrayList<Book> findAllBooksByName(String name){
        ArrayList<Book> specBooks = new ArrayList<>();
        for(Book book : bookMap.values()){
            if(book.getName().equals(name)){
                specBooks.add(book);
            }
        }
        return specBooks;
    }
    public Book addBook(Book book){
        if(bookMap.containsKey(book.getId())){
            return null;
        }
        bookMap.put(book.getId(), book);
        return book;
    }
    public Book getBook(String id){
        if(bookMap.containsKey(id)){
            return bookMap.get(id);
        }
        return null;
    }
    public Book updateBook(Book book){
        if(bookMap.containsKey(book.getId())){
            Book book1 = bookMap.get(book.getId());
            book1.setName(book.getName());
            book1.setNumberOfPages(book.getNumberOfPages());
            book1.setAuthorId(book.getAuthorId());
            return book1;
        }
        return null;
    }
    public boolean removeBook(String id) {
        if (bookMap.containsKey(id)) {
            bookMap.remove(id);
            return true;
        }
        return false;
    }
}

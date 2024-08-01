package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.model.BookAndAuthor;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import com.BooksAndAuthorsManagement.repo.RelationRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class BookAndAuthorService {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;
    private RelationRepo relationRepo;
    private AuthorService authorService;
    public BookAndAuthorService(BookRepo bookRepo, AuthorRepo authorRepo,RelationRepo relationRepo){
        this.authorRepo = authorRepo;
        this.bookRepo=bookRepo;
        this.relationRepo = relationRepo;
    }
    public BookAndAuthor getBookDetails(int bookId){
        BookService bookService = new BookService(bookRepo,relationRepo,authorService);
        if(bookService.findBookById(bookId) == null) {
            return null;
        }
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        Book book = bookRepo.getBookById(bookId);
        List<Integer> authorIds = relationRepo.getAuthorId(bookId);
        book.setAuthors(authorIds);
        List<Author> authors = new ArrayList<>();
        for(int id : authorIds){
            authors.add(authorRepo.getAuthorById(id));
        }
        bookAndAuthor.setBookId(bookId);
        bookAndAuthor.setBookName(book.getName());
        bookAndAuthor.setNumberOfPages(book.getNumberOfPages());
        bookAndAuthor.setAuthors(authors);
        return bookAndAuthor;
    }

}

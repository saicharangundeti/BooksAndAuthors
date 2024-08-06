package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TestBookService {
    @Test
    public void testFindBookById_BookFound() {
        BookRepo bookRepoMock = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);

        when(relationService.findAuthorIds(bookId)).thenReturn(Set.of(2, 3, 4));
        book.setAuthors(relationService.findAuthorIds(bookId));

        when(bookRepoMock.getBookById(bookId)).thenReturn(book);
        BookService bookService = new BookService(bookRepoMock, relationService, authorService);

        Book result = bookService.findBookById(bookId);

        assertEquals(result.getId(), bookId, "Should return valid bookId");
        assertEquals(result.getAuthorIds().size(), book.getAuthorIds().size(), "Should return correct authorsId Size");

    }

    @Test
    public void testFindBookById_BookNotFound() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);
        when(bookRepo.getBookById(bookId)).thenReturn(null);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        Book result = bookService.findBookById(bookId);

        assertEquals(result, null, "Should return null");


    }

    @Test
    public void testFindBookByName_BookFound() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        String bookName = "sai";
        Book book = new Book();
        book.setName(bookName);
        when(bookRepo.getBookByName(bookName)).thenReturn(book);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        Book result = bookService.findBookByName(bookName);

        assertEquals(result.getName(), book.getName(), "Should return Valid Book Name");


    }

    @Test
    public void testFindBookByName_BookNotFound() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        String bookName = "sai";
        Book book = new Book();
        book.setName(bookName);
        when(bookRepo.getBookByName(bookName)).thenReturn(null);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        Book result = bookService.findBookByName(bookName);

        assertEquals(result, null, "Should return null");

    }
    @Test
    public void testSaveBook_BookNotExitAndAuthorsExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookByName(book.getName())).thenReturn(null);
        when(authorService.findAuthorById(2)).thenReturn(new Author(2,"Author 1"));
        when(authorService.findAuthorById(3)).thenReturn(new Author(3,"Author 2"));

        Book result = bookService.saveBook(book);

        assertNotNull(result,"Result Should not be Null");
        verify(bookRepo,times(1)).saveBook(book);

    }
    @Test
    public void testSaveBook_BookNotExistAndAuthorsNotExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookByName(book.getName())).thenReturn(null);
        when(authorService.findAuthorById(2)).thenReturn(new Author(2,"Author 1"));
        when(authorService.findAuthorById(3)).thenReturn(null);

        Book result = bookService.saveBook(book);

        assertNull(result,"Result Should be Null");
        verify(bookRepo,never()).saveBook(book);
    }
    @Test
    public void testSaveBook_BookExist_AuthorsExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookByName(book.getName())).thenReturn(book);
        when(authorService.findAuthorById(2)).thenReturn(new Author(2,"Author 1"));
        when(authorService.findAuthorById(3)).thenReturn(new Author(3,"Author 2"));

        Book result = bookService.saveBook(book);

        assertNull(result,"Result Should  be Null");
        verify(bookRepo,never()).saveBook(book);


    }
    @Test
    public void testUpdateBook_BookExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookById(book.getId())).thenReturn(book);
        Book updateBook = new Book();
        book.setName("Update Book");
        Set<Integer> updatedAuthorIds = Set.of(1,4);
        book.setAuthors(updatedAuthorIds);

        Book result = bookService.updateBook(book.getId(),updateBook);

        assertNotNull(result,"Result Should not be Null");
        verify(bookRepo,times(1)).updateBook(book.getId(),updateBook);
        verify(relationService,times(1)).deleteBookAndAuthor(book.getId());

    }
    @Test
    public void testUpdateBook_BookNotExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookById(book.getId())).thenReturn(null);
        Book updateBook = new Book();
        book.setName("Update Book");
        Set<Integer> updatedAuthorIds = Set.of(1,4);
        book.setAuthors(updatedAuthorIds);

        Book result = bookService.updateBook(book.getId(),updateBook);

        assertNull(result,"Result Should be Null");
        verify(bookRepo,never()).updateBook(book.getId(),updateBook);
        verify(relationService,never()).deleteBookAndAuthor(book.getId());
    }
    @Test
    public void testDeleteBook_BookExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookById(book.getId())).thenReturn(book);

        Boolean result = bookService.deleteBook(book.getId());

        assertNotNull(result,"Result Should not be Null");
        verify(bookRepo,times(1)).removeBook(book.getId());
        verify(relationService,times(1)).deleteBookAndAuthor(book.getId());

    }
    @Test
    public void testDeleteBook_BookNotExist() {
        BookRepo bookRepo = mock(BookRepo.class);//mock bookREpo
        AuthorService authorService = mock(AuthorService.class);//mock AuthorService
        RelationService relationService = mock(RelationService.class);//mock RelationService;
        Book book = new Book();
        book.setName("Book 1");
        book.setId(1);
        Set<Integer> authorIds = Set.of(2,3);
        book.setAuthors(authorIds);
        BookService bookService = new BookService(bookRepo, relationService, authorService);

        when(bookRepo.getBookById(book.getId())).thenReturn(null);

        Boolean result = bookService.deleteBook(book.getId());

        assertFalse(result,"Result Should be False");
        verify(bookRepo,never()).removeBook(book.getId());
        verify(relationService,never()).deleteBookAndAuthor(book.getId());

    }

}

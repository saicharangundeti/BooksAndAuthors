package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.model.BookAndAuthor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TestBookAndAuthorService {
    @Test
    public void testGetBookDetails_Success(){
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);
        book.setName("Book 1");
        book.setNumberOfPages(100);

        Set<Integer> authorIds = new HashSet<>();
        authorIds.add(1);
        authorIds.add(2);

        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Author 1");

        Author author2 = new Author();
        author2.setName("Author 2");
        author2.setId(2);


        BookService bookService = mock(BookService.class);
        AuthorService authorService = mock(AuthorService.class);
        RelationService relationService = mock(RelationService.class);


        when(bookService.findBookById(bookId)).thenReturn(book);
        when(relationService.findAuthorIds(bookId)).thenReturn(authorIds);
        when(authorService.findAuthorById(1)).thenReturn(author1);
        when(authorService.findAuthorById(2)).thenReturn(author2);

        BookAndAuthorService bookAndAuthorService  = new BookAndAuthorService(bookService,authorService,relationService);

        BookAndAuthor result = bookAndAuthorService.getBookDetails(bookId);

        assertNotNull(result);
        assertEquals("Book 1",result.getBookName());
        assertEquals(100,result.getNumberOfPages());
        assertEquals(2,result.getAuthors().size());

        verify(bookService,times(1)).findBookById(bookId);
        verify(relationService,times(1)).findAuthorIds(bookId);
        verify(authorService,times(1)).findAuthorById(1);
        verify(authorService,times(1)).findAuthorById(2);
        verifyNoMoreInteractions(bookService,authorService,relationService);

    }
    @Test
    public void testGetBookDetails_Failed() {
        int bookId = 1;
        Book book = new Book();
        book.setId(bookId);

        BookService bookService = mock(BookService.class);
        AuthorService authorService = mock(AuthorService.class);
        RelationService relationService = mock(RelationService.class);

        when(bookService.findBookById(bookId)).thenReturn(null);

        BookAndAuthorService bookAndAuthorService = new BookAndAuthorService(bookService, authorService, relationService);

        BookAndAuthor result = bookAndAuthorService.getBookDetails(bookId);

        assertNull(result);
        verify(bookService,times(1)).findBookById(bookId);
        verifyNoMoreInteractions(bookService,authorService,relationService);

    }
}

package com.BooksAndAuthorsManagement.Controller;

import com.BooksAndAuthorsManagement.Service.BookAndAuthorService;
import com.BooksAndAuthorsManagement.controller.BookAndAuthorController;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.BookAndAuthor;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestBookAndAuthorsController {
    @Test
    public void testGetBookAndAuthors_Success(){

        Author author1 = new Author(1,"charan");
        Author author2 = new Author(2,"vamshi");

        BookAndAuthorService bookAndAuthorServiceMock = mock(BookAndAuthorService.class);
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        bookAndAuthor.setBookId(1);
        bookAndAuthor.setAuthors(Arrays.asList(author1,author2));

        when(bookAndAuthorServiceMock.getBookDetails(anyInt())).thenReturn(bookAndAuthor);
        BookAndAuthorController bookAndAuthorController =  new BookAndAuthorController(bookAndAuthorServiceMock);

        ResponseEntity<BookAndAuthor> response = bookAndAuthorController.getBookDetails(1);

        assertEquals(HttpStatus.OK,response.getStatusCode(),"Should be a Ok Http Status Code");
        assertEquals(2,response.getBody().getAuthors().size(),"Should be a valid size of authors");

    }
    @Test
    public void testGetBookAndAuthors_Failure(){

        Author author1 = new Author(1,"charan");
        Author author2 = new Author(2,"vamshi");

        BookAndAuthorService bookAndAuthorServiceMock = mock(BookAndAuthorService.class);
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        bookAndAuthor.setBookId(1);
        bookAndAuthor.setAuthors(Arrays.asList(author1,author2));

        when(bookAndAuthorServiceMock.getBookDetails(0)).thenReturn(null);
        BookAndAuthorController bookAndAuthorController =  new BookAndAuthorController(bookAndAuthorServiceMock);

        ResponseEntity<BookAndAuthor> response = bookAndAuthorController.getBookDetails(0);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode(),"Should be a Not found Http Status Code");
        assertEquals(null,response.getBody(),"Should be a null");

    }

}

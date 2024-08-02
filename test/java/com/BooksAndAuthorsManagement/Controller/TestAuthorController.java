package com.BooksAndAuthorsManagement.Controller;

import com.BooksAndAuthorsManagement.Service.AuthorService;
import com.BooksAndAuthorsManagement.controller.AuthorController;
import com.BooksAndAuthorsManagement.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class TestAuthorController {
    @Test
    public void testGetAuthorByIdReturnsOkStatusCode() {

        // Prepare
        AuthorService authorServiceMoc = mock(AuthorService.class);
        when(authorServiceMoc.getAuthorById(anyInt())).thenReturn(new Author(1, "charan"));
        AuthorController authorController = new AuthorController(authorServiceMoc);

        // Test
        ResponseEntity<Author> response = authorController.getAnAuthor(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Http Status should be OK");
    }

    @Test
    public void testGetAnAuthorByIdReturnsNotFoundStatusCode() {
        //preparation
        AuthorService authorServiceMoc = mock(AuthorService.class);
        when(authorServiceMoc.getAuthorById(1)).thenReturn(new Author(1, "charan"));
        AuthorController authorController = new AuthorController(authorServiceMoc);

        //Test
        ResponseEntity<Author> response = authorController.getAnAuthor(2);

        //assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Http Status should be Not Found");
    }

    @Test
    public void testGetAnAuthorByIdReturnsValidAuthor() {

        AuthorService authorServiceMoc = mock(AuthorService.class);
        when(authorServiceMoc.getAuthorById(1)).thenReturn(new Author(1, "charan"));
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.getAnAuthor(1);

        assertEquals("charan", response.getBody().getName(), "Get author should return valid author Name");
    }

    @Test
    public void testGetAnAuthorByIdReturnsNull() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        when(authorServiceMoc.getAuthorById(2)).thenReturn(null);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.getAnAuthor(2);

        assertNull(response.getBody(), "get author should return null");
    }

    @Test
    public void testGetAllAuthors_success() {

        AuthorService authorServiceMoc = mock(AuthorService.class);
        List<Author> expectedAuthors = Arrays.asList(new Author(1, "sai"), new Author(2, "charan"));
        when(authorServiceMoc.findAllAuthors()).thenReturn(expectedAuthors);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<List<Author>> response = authorController.getAllAuthors();

        assertEquals(expectedAuthors, response.getBody(), "Should be all expected authors");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Should be ok status code");
        assertEquals(expectedAuthors.size(), response.getBody().size(), "Should be a valid size");
    }
    @Test
    public void testGetAuthorByName_success(){
        AuthorService authorServiceMoc = mock(AuthorService.class);
        Author author = new Author(1,"sai");
        when(authorServiceMoc.findAuthorByName("sai")).thenReturn(author);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.getAuthorByName("sai");

        assertEquals(1,response.getBody().getId(),"Should return valid id");
        assertEquals(HttpStatus.OK,response.getStatusCode(),"Should return ok Http Status code");
    }
    @Test
    public void testGetAuthorByName_failure(){
        AuthorService authorServiceMoc = mock(AuthorService.class);
        Author author = new Author(1,"sai");
        when(authorServiceMoc.findAuthorByName("charan")).thenReturn(null);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.getAuthorByName("charan");

        assertEquals(null,response.getBody(),"Should return null");
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode(),"Should return Not Found Http Status code");
    }

    @Test
    public void testPostAuthor_Success() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        Author author = new Author(1, "sai");
        when(authorServiceMoc.saveAuthor(any(Author.class))).thenReturn(author);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.postAuthor(author);

        assertEquals(response.getStatusCode(), HttpStatus.OK, "should be a ok http status code");
        assertEquals(response.getBody().getName(), "sai", "should be a valid name");
    }

    @Test
    public void testPostAuthor_failure() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        Author author = new Author(1, "sai");
        when(authorServiceMoc.saveAuthor(any(Author.class))).thenReturn(null);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.postAuthor(author);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST, "should be a Not found http status code");
        assertEquals(response.getBody(), null, "should be null");

    }

    @Test
    public void testUpdateAuthor_Success() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        Author updatedAuthor = new Author(1, "updated name");
        when(authorServiceMoc.updateAuthor(updatedAuthor)).thenReturn(updatedAuthor);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.updateAuthor(updatedAuthor);

        assertEquals(response.getStatusCode(), HttpStatus.OK, "should be a ok  http status code");
        assertEquals(response.getBody().getName(), "updated name", "should be null");
    }

    @Test
    public void testUpdateAuthor_Failure() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        Author updatedAuthor = new Author(1, "updated name");
        when(authorServiceMoc.updateAuthor(updatedAuthor)).thenReturn(null);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Author> response = authorController.updateAuthor(updatedAuthor);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND, "should be a Not Found http status code");
        assertEquals(response.getBody(), null, "updated name should be null");
    }

    @Test
    public void testDeleteAuthor_Success() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        when(authorServiceMoc.deleteAuthorById(anyInt())).thenReturn(true);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Boolean> response = authorController.deleteAuthor(1);

        assertEquals(HttpStatus.OK, response.getStatusCode(), "should be ok status code");
        assertEquals(true, response.getBody(), "should be true");
    }
    @Test
    public void testDeleteAuthor_Failure() {
        AuthorService authorServiceMoc = mock(AuthorService.class);
        when(authorServiceMoc.deleteAuthorById(0)).thenReturn(false);
        AuthorController authorController = new AuthorController(authorServiceMoc);

        ResponseEntity<Boolean> response = authorController.deleteAuthor(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "should be not found status code");
        assertEquals(false, response.getBody(), "should be false");
    }
}


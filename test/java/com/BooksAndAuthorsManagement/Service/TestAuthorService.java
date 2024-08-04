package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestAuthorService {
    @Test
    public void testFindAllAuthors_Success(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        Author author = new Author(1,"sai");
        author.setId(author.getId());
        when(authorRepoMock.findAll()).thenReturn(Arrays.asList(author));
        AuthorService authorService = new AuthorService(authorRepoMock);

       List<Author> result = authorService.findAllAuthors();

        assertEquals(1,result.size(),"Authors size should be valid");
    }
    @Test
    public void testFindAuthorByName_AuthorFound(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        String authorName = "sai";
        Author author = new Author();
        author.setName(authorName);
        when(authorRepoMock.getAuthorByName(authorName)).thenReturn(author);
        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.findAuthorByName(authorName);

        assertNotEquals(null,result,"Should not be a null");
        assertEquals(authorName,result.getName(),"should return correct authorId");

    }
    @Test
    public void testFindAuthorByName_AuthorNotFound(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        String authorName = "";
        Author author = new Author();
        author.setName(authorName);
        when(authorRepoMock.getAuthorByName("")).thenReturn(null);
        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.findAuthorByName(authorName);

        assertEquals(null,result,"Should not be a null");
        //assertEquals(authorName,result.getName(),"should return correct authorId");

    }

    @Test
    public void testFindAuthorById_AuthorFound(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        int authorId = 1;
        Author author = new Author();
        author.setId(authorId);
        when(authorRepoMock.getAuthorById(authorId)).thenReturn(author);
        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.findAuthorById(authorId);

        assertNotEquals(null,result,"Should not be a null");
        assertEquals(authorId,result.getId(),"should return correct authorId");

    }

    @Test
    public void testFindAuthorById_AuthorNotFound(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        int authorId = 1;
        when(authorRepoMock.getAuthorById(authorId)).thenReturn(null);
        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.findAuthorById(authorId);

        assertEquals(null,result,"should return  null ");

    }

    @Test
    public void testSaveAuthor_Success(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        Author author = new Author(1,"sai");
        when(authorRepoMock.getAuthorByName(null)).thenReturn(author);

        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.saveAuthor(author);

        assertNotEquals(null,result,"Should not a null");
        assertEquals("sai",result.getName(),"Should be correct authorName");

    }
    @Test
    public void testSaveAuthor_Failure(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        String  authorName = "sai";
        int authorId = 1;
        Author author = new Author();
        author.setName(authorName);
        author.setId(authorId);
        when(authorRepoMock.getAuthorByName(author.getName())).thenReturn(author);

        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.saveAuthor(author);
        //a//ssertEquals("null,result,"Should not a null\",\"result should be a null\"");

        assertEquals(null,result,"Should not a null result should be a null");
        //assertEquals("sai",result.getName(),"Should be correct authorName");

    }
    @Test
    public void testUpdateAuthor_Success(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        int authorId = 1;
        String authorName = "sai";
        Author author = new Author();
        author.setId(authorId);
        author.setName(authorName);
        when(authorRepoMock.getAuthorById(authorId)).thenReturn(author);

        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.updateAuthor(author);

        assertEquals(authorId,result.getId(),"Should be a valid authorId");
        assertNotEquals(null,result,"Should not be a null");


    }
    @Test
    public void testUpdateAuthor_Failure(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        int authorId = 1;
        Author author = new Author();
        author.setId(authorId);
        when(authorRepoMock.getAuthorById(authorId)).thenReturn(null);

        AuthorService authorService = new AuthorService(authorRepoMock);

        Author result = authorService.updateAuthor(author);

        assertEquals(null,result,"Should be a null");

    }
    @Test
    public void testDeleteAuthor_Success(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        int authorId = 1;
        String authorName = "sai";
        Author author = new Author();
        author.setId(authorId);
        author.setName(authorName);
        when(authorRepoMock.getAuthorById(authorId)).thenReturn(author);

        AuthorService authorService = new AuthorService(authorRepoMock);

        Boolean result = authorService.deleteAuthorById(authorId);

      //  assertEquals(authorId,result.getId(),"Should be a valid authorId");
        assertEquals(true,result,"Should not be true");


    }
    @Test
    public void testDeleteAuthor_Failure(){
        AuthorRepo authorRepoMock = mock(AuthorRepo.class);
        int authorId = 1;
        String authorName = "sai";
        Author author = new Author();
        author.setId(authorId);
        author.setName(authorName);
        when(authorRepoMock.getAuthorById(authorId)).thenReturn(null);

        AuthorService authorService = new AuthorService(authorRepoMock);

        Boolean result = authorService.deleteAuthorById(authorId);

        //assertEquals(authorId,result.getId(),"Should be a valid authorId");
        assertEquals(false,result,"Should not be false");


    }

}



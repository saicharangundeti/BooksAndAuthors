package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAuthorService {
    @Test
    public void testGetAuthorByIdReturnsValidName(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author = authorService.saveAuthor(new Author("sai","A1"));
        Author response = authorService.getAuthorById("A1");
        assertEquals("sai",response.getName());
    }
    @Test
    public void testGetAuthorByIdReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author = authorService.saveAuthor(new Author("sai","A1"));
        assertEquals(null ,authorService.getAuthorById("A2"));
    }
    @Test
    public void testFindAllAuthorsReturnsValidSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Author author2 = authorService.saveAuthor(new Author("charan","A2"));
        assertEquals(2 ,authorService.findAllAuthors().size());
    }
    @Test
    public void testFindAllAuthorsByNameReturnsValidSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Author author2 = authorService.saveAuthor(new Author("charan","A2"));
        assertEquals(1,authorService.findAllAuthorByName("sai").size());
    }

    @Test
    public void testSaveAuthorReturnsValidName(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Author response = authorService.saveAuthor(new Author("charan","A2"));
        assertEquals("charan",response.getName());
    }
    @Test
    public void testSaveAuthorReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Author response = authorService.saveAuthor(new Author("charan","A1"));
        assertEquals(null,response);
    }
    @Test
    public void testUpdateAuthorReturnsValidName(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Author response = authorService.updateAuthor(new Author("charan","A1"));
        assertEquals("charan",response.getName());
    }
    @Test
    public void testUpdateAuthorReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Author response = authorService.updateAuthor(new Author("charan","A2"));
        assertEquals(null,response);
    }
    @Test
    public void testDeleteAuthorReturnsTrue(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Boolean response = authorService.deleteAuthorById("A1");
        assertEquals(true,response);
    }
    @Test
    public void testDeleteAuthorReturnsFalse(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        Author author1= authorService.saveAuthor(new Author("sai","A1"));
        Boolean response = authorService.deleteAuthorById("A2");
        assertEquals(false,response);
    }



}

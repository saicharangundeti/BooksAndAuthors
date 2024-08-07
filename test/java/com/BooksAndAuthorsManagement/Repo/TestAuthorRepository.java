package com.BooksAndAuthorsManagement.Repo;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAuthorRepository {

    @Test
    public void testFindAllAuthors() {

        String query1 = "SELECT * FROM authors ORDER BY id asc";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);


        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Author 1");

        Author author2 = new Author();
        author2.setName("Author 2");
        author2.setId(2);

        List<Author> expectedAuthors = Arrays.asList(author1, author2);
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);
        //Arrays.asList(author1,author2)
        when(jdbcTemplate.query(eq(query1), any(RowMapper.class))).thenReturn(expectedAuthors);

        when(authorRepo.findAll()).thenReturn(expectedAuthors);

        List<Author> result = authorRepo.findAll();

        assertEquals(expectedAuthors, result);
    }

    @Test
    public void testGetAuthorById_AuthorExit() {

        String query1 = "SELECT * FROM authors WHERE id = ?";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        int authorId = 1;
        Author author = new Author();
        author.setId(authorId);
        author.setName("Author 1");
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);
        //Arrays.asList(author1,author2)
        when(jdbcTemplate.queryForObject(eq(query1), any(Object[].class), any(RowMapper.class))).thenReturn(author);

        when(authorRepo.getAuthorById(authorId)).thenReturn(author);

        Author result = authorRepo.getAuthorById(authorId);

        assertEquals(author.getName(), result.getName());
    }

    @Test
    public void testGetAuthorById_AuthorNotExit() {

        String query1 = "SELECT * FROM authors WHERE id = ?";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        int authorId = 1;
        Author author = new Author();
        author.setId(authorId);
        author.setName("Author 1");
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);

        when(jdbcTemplate.queryForObject(eq(query1), any(Object[].class), any(RowMapper.class))).thenThrow(new EmptyResultDataAccessException(1));

        when(authorRepo.getAuthorById(authorId)).thenReturn(author);

        Author result = authorRepo.getAuthorById(authorId);

        assertNull(result);
    }

    @Test
    public void testGetAuthorByName_AuthorExit() {

        String query1 = "SELECT * FROM authors WHERE name = ?";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        String authorName = "Author 1";
        Author author = new Author();
        author.setId(1);
        author.setName(authorName);
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);

        when(jdbcTemplate.queryForObject(eq(query1), any(Object[].class), any(RowMapper.class))).thenReturn(author);

        when(authorRepo.getAuthorByName(authorName)).thenReturn(author);

        Author result = authorRepo.getAuthorByName(authorName);

        assertEquals(author.getName(), result.getName());
    }
    @Test
    public void testGetAuthorByName_AuthorNotExit() {

        String query1 = "SELECT * FROM authors WHERE name = ?";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        String authorName = "Author 1";
        Author author = new Author();
        author.setId(1);
        author.setName(authorName);
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);

        when(jdbcTemplate.queryForObject(eq(query1), any(Object[].class), any(RowMapper.class))).thenThrow(new EmptyResultDataAccessException(1));

        when(authorRepo.getAuthorByName(authorName)).thenReturn(author);

        Author result = authorRepo.getAuthorByName(authorName);

        assertNull( result);
    }
    @Test
    public void testSaveAuthor_Success() {

        String query1 = "INSERT INTO authors (id,name) values (?,?)";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        int authorId = 1;
        String authorName = "Author 1";
        Author author = new Author(authorId,authorName);
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);

        when(jdbcTemplate.update(eq(query1),eq(authorId),eq(authorName))).thenReturn(1);

        when(authorRepo.saveAuthor(author)).thenReturn(  1);

        int result = authorRepo.saveAuthor(author);

        assertEquals(1,result);
    }
    @Test
    public void testUpdateAuthor_Success() {

        String query1 = "UPDATE authors set values(?) WHERE id = ?";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        int authorId = 1;
        String authorName = "Author 1";
        Author author = new Author(authorId,authorName);
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);

        when(jdbcTemplate.update(eq(query1),eq(authorName),eq(authorId))).thenReturn(1);

        when(authorRepo.updateAuthor(author)).thenReturn(  1);

        int result = authorRepo.updateAuthor(author);

        assertEquals(1,result);
    }
    @Test
    public void testDeleteAuthor_Success() {

        String query1 = "DELETE FROM authors WHERE id = ?";
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        int authorId = 1;
        String authorName = "Author 1";
        Author author = new Author(authorId,authorName);
        AuthorRepo authorRepo = new AuthorRepo(jdbcTemplate);

        when(jdbcTemplate.update(eq(query1),eq(authorId))).thenReturn(1);

        when(authorRepo.removeAuthor(authorId)).thenReturn(  1);

        int result = authorRepo.removeAuthor(authorId);

        assertEquals(1,result);
    }
}
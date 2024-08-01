package com.BooksAndAuthorsManagement.repo;

import com.BooksAndAuthorsManagement.model.Author;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorRepo {
    private JdbcTemplate jdbcTemplate;
    public AuthorRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    private final class AuthorMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet rs, int rowNu) throws SQLException{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            return author;

        }
    }
    public List<Author> findAll(){
        String query1 = "SELECT * FROM authors ORDER BY id asc";
        return  jdbcTemplate.query(query1,new AuthorMapper());
    }
    public Author getAuthorById(int id){
        String query1 = "SELECT * FROM authors WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(query1,new Object[]{id},new AuthorMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public Author getAuthorByName(String  name){
        String query1 = "SELECT * FROM authors WHERE name = ?";
        try {
            return jdbcTemplate.queryForObject(query1,new Object[]{name},new AuthorMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public int saveAuthor(Author author) {
            String query1 = "INSERT INTO authors (id,name) values(?,?)";
            return jdbcTemplate.update(query1, author.getId(), author.getName());
        }
    public int updateAuthor(Author author){

        String query1 = "UPDATE authors SET values(?) WHERE id = ?";
        return jdbcTemplate.update(query1,author.getName(),author.getId());
    }
    public  int  removeAuthor(int id){
        String query1 = "DELETE FROM authors WHERE id = ?";
        return jdbcTemplate.update(query1,id);
    }
}

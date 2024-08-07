package com.BooksAndAuthorsManagement.repo;
import com.BooksAndAuthorsManagement.Exeptions.CustomSQLExceptions;
import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Repository
public class BookRepo {
    JdbcTemplate jdbcTemplate;
    public BookRepo( JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private final class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNu) throws SQLException{
            Book book  = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setNumberOfPages(rs.getInt("number_of_pages"));
            return book;

        }
    }
    public List<Book> findAllBooks(){
        String query1 = "SELECT * FROM books ORDER BY id asc";
        return jdbcTemplate.query(query1,new BookMapper());
    }

    public int saveBook(Book book){
        try {
            String query1 = "INSERT INTO books(id,name,number_of_pages) values (?,?,?)";
            return jdbcTemplate.update(query1, book.getId(), book.getName(), book.getNumberOfPages());

        }
        catch (DataIntegrityViolationException e){
            throw new CustomSQLExceptions(e.getMessage());
        }
    }


    public Book getBookByName(String name){
        String query1 = "SELECT * FROM books WHERE name = ?";
        try {
            return jdbcTemplate.queryForObject(query1,new Object[]{name},new BookMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public Book getBookById(int id){
        String query1 = "SELECT * FROM books WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(query1,new Object[]{id},new BookMapper());
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public  int updateBook(int id,Book book){
        //"UPDATE authors_table SET values(?) WHERE id = ?"
        String query1 = "UPDATE books SET name=?,number_of_pages=? WHERE id = ?";
        return jdbcTemplate.update(query1,book.getName(),book.getNumberOfPages(),id);

    }

    public int removeBook(int id) {
        String query1 = "DELETE FROM books WHERE id = ?";
        return jdbcTemplate.update(query1,id);
    }

}

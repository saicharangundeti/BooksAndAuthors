package com.BooksAndAuthorsManagement.repo;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.BooksAndAuthorsManagement.Exeptions.CustomSQLExceptions;
import com.BooksAndAuthorsManagement.model.Book;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
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
            book.setAuthorId(rs.getInt("author_id"));
            return book;

        }
    }
    public List<Book> findAllBooks(){
        String query1 = "SELECT * FROM books ORDER BY id asc";
        return jdbcTemplate.query(query1,new BookMapper());
    }

    public int saveBook(Book book){
        try {
            String query1 = "INSERT INTO books(id,name,number_of_pages,author_id) values (?,?,?,?)";
            return jdbcTemplate.update(query1, book.getId(), book.getName(), book.getNumberOfPages(), book.getAuthorId());

        }
        catch (DataIntegrityViolationException e){
            throw new CustomSQLExceptions(e.getMessage());

        }


    }
    public int saveBookAndAuthorIntoRelationTable(Book book){
        String query1 = "INSERT INTO author_book_relation(author_id,book_id) values (?,?)";
        int bookId = getBookByName(book.getName()).getId();
        return jdbcTemplate.update(query1,book.getAuthorId(),bookId);
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
    public  int updateBook(Book book){
        //"UPDATE authors_table SET values(?) WHERE id = ?"
        String query1 = "UPDATE books SET name=?,number_of_pages=?,author_id=? WHERE id = ?";
        return jdbcTemplate.update(query1,book.getName(),book.getNumberOfPages(),book.getAuthorId(),book.getId());

    }
    public  int updateBookIdAndAuthorIdInRelationTable(Book book){
        String query1 = "UPDATE author_book_relation SET author_id=? WHERE book_id = ?";
        return jdbcTemplate.update(query1,book.getAuthorId(),book.getId());

    }
    public int removeBook(int id) {
        String query1 = "DELETE FROM books WHERE id = ?";
        return jdbcTemplate.update(query1,id);
    }
    public int removeBookAndAuthorInRelationTable(int id) {
        String query1 = "DELETE FROM author_book_relation WHERE book_id = ?";
        return jdbcTemplate.update(query1,id);
    }
}

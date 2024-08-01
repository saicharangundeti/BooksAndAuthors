//package com.BooksAndAuthorsManagement.repo;
//
//import com.BooksAndAuthorsManagement.model.Author;
//import com.BooksAndAuthorsManagement.model.Book;
//import com.BooksAndAuthorsManagement.model.BookAndAuthor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class BookAndAuthorsRepo {
//    JdbcTemplate jdbcTemplate;
//    public BookAndAuthorsRepo(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate=jdbcTemplate;
//    }
//    private final class BookAndAuthorMapper implements RowMapper<BookAndAuthor>{
//
//        @Override
//        public BookAndAuthor mapRow(ResultSet rs, int rowNU) throws SQLException {
//            BookAndAuthor bookAndAuthor = new BookAndAuthor();
//
//
//        }
//
//    }
//
//
//}

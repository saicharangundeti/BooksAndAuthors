package com.BooksAndAuthorsManagement.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Repository

public class RelationRepo {
    private JdbcTemplate jdbcTemplate;
    public RelationRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    private final class RelationMapper implements RowMapper<Integer>{
        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt("author_id");
        }

    }
    public Set<Integer> getAuthorIds(int id){
        String query1 = "Select author_id from author_book_relation where book_id = ?";
        return (Set<Integer>) jdbcTemplate.query(query1,new RelationMapper(),id);
    }
    public  int updateBookIdAndAuthorId(int id, Set<Integer> authorIds){
        int count = 0;
        for(int authorId:authorIds) {
            String query1 = "INSERT INTO author_book_relation(author_id,book_id) values (?,?)";
            count++;
            jdbcTemplate.update(query1,authorId,id);
        }
        return count;
    }
    public int removeBookAndAuthor(int id) {
        String query1 = "DELETE FROM author_book_relation WHERE book_id = ?";
        return jdbcTemplate.update(query1,id);
    }

}

package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.repo.RelationRepo;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service

public class RelationService {
    private RelationRepo relationRepo;

    public RelationService(RelationRepo relationRepo){
        this.relationRepo = relationRepo;
    }


    public Set<Integer> findAuthorIds(int bookId){
        return relationRepo.getAuthorIds(bookId);
    }
    public  int saveBookIdAndAuthorIds(int id, Set<Integer> authorIds){
        return relationRepo.saveBookIdAndAuthorIds(id,authorIds);
    }

    public int deleteBookAndAuthor(int id) {
        return relationRepo.removeBookAndAuthor(id);
    }
}

package com.BooksAndAuthorsManagement.Exeptions;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class CustomSQLExceptions extends RuntimeException{


    public CustomSQLExceptions(String message) {
        super(message);

    }
}

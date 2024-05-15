package com.example.app.repository.book;

import com.example.app.service.book.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookRepository {

    @Insert("""
            INSERT INTO books (title, author)
            VALUES (#{title}, #{author});
            """)
    void insert(String title, String author);

    @Select("""
            SELECT * FROM books;
            """)
    List<Book> select();
}

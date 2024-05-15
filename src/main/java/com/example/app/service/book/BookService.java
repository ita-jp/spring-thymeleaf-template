package com.example.app.service.book;

import com.example.app.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void register(String title, String author) {
        bookRepository.insert(title, author);
    }

    public List<Book> findAll() {
        return bookRepository.select();
    }
}

package com.jo.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final Map<Long, Book> books = new HashMap<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
    }

    public void updateBook(Long id, Book updatedBook) {
        if (books.containsKey(id)) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
        }
    }

    public void deleteBook(Long id) {
        books.remove(id);
    }
}

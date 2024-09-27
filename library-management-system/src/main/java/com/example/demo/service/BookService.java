package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.BookDTO;

public interface BookService {
	BookDTO getBookById(Long id);
    List<BookDTO> getAllBooks();
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
}

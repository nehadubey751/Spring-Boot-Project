package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
@RestController
@RequestMapping("/api/Book")
public class BookController {
	 @Autowired
	    private BookService bookService;

	    @GetMapping("/{id}")
	    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
	        BookDTO bookDTO = bookService.getBookById(id);
	        return bookDTO != null ? ResponseEntity.ok(bookDTO) : ResponseEntity.notFound().build();
	    }

	    @GetMapping
	    public ResponseEntity<List<BookDTO>> getAllBooks() {
	        List<BookDTO> books = bookService.getAllBooks();
	        return ResponseEntity.ok(books);
	    }

	    @PostMapping
	    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
	        BookDTO createdBookDTO = bookService.saveBook(bookDTO);
	        return ResponseEntity.ok(createdBookDTO);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
	        BookDTO updatedBookDTO = bookService.updateBook(id, bookDTO);
	        return updatedBookDTO != null ? ResponseEntity.ok(updatedBookDTO) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	        bookService.deleteBook(id);
	        return ResponseEntity.noContent().build();
	    }
	}
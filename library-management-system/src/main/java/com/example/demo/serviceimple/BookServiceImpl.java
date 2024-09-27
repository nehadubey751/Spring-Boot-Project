package com.example.demo.serviceimple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.BookDTO;
import com.example.demo.entitiy.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	 @Autowired
	    private BookRepository bookRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public BookDTO getBookById(Long id) {
	        Optional<Book> book = bookRepository.findById(id);
	        return book.map(b -> modelMapper.map(b, BookDTO.class)).orElse(null);
	    }

	    @Override
	    public List<BookDTO> getAllBooks() {
	        List<Book> books = bookRepository.findAll();
	        return books.stream()
	                    .map(book -> modelMapper.map(book, BookDTO.class))
	                    .collect(Collectors.toList());
	    }

	    @Override
	    public BookDTO saveBook(BookDTO bookDTO) {
	        Book book = modelMapper.map(bookDTO, Book.class);
	        Book savedBook = bookRepository.save(book);
	        return modelMapper.map(savedBook, BookDTO.class);
	    }

	    @Override
	    public BookDTO updateBook(Long id, BookDTO bookDTO) {
	        if (bookRepository.existsById(id)) {
	            Book book = modelMapper.map(bookDTO, Book.class);
	            book.setId(id);
	            Book updatedBook = bookRepository.save(book);
	            return modelMapper.map(updatedBook, BookDTO.class);
	        }
	        return null;
	    }

	    @Override
	    public void deleteBook(Long id) {
	        bookRepository.deleteById(id);
	    }
	}
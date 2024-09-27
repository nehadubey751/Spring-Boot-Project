package com.example.demo.dto;
import java.util.List;

import com.example.demo.entitiy.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String author;
    private String isbn;
    private Book book;

}

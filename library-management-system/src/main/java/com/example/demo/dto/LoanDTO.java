package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entitiy.Book;
import com.example.demo.entitiy.Member;

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
public class LoanDTO {
	    private LocalDateTime loanDate;
	    private LocalDateTime returnDate;
	    private Book book;
	    private Member member;
}

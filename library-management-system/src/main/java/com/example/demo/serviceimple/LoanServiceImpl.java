package com.example.demo.serviceimple;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoanDTO;
import com.example.demo.entitiy.Loan;
import com.example.demo.entitiy.Member;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LoanRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	 @Autowired
	    private LoanRepository loanRepository;

	    @Autowired
	    private ModelMapper modelMapper;
	    
	    @Autowired
	    private BookRepository bookRepository;
	    
	    @Autowired
	    private MemberRepository memberRepository;

	    @Override
	    public LoanDTO getLoanById(Long id) {
	        Optional<Loan> loan = loanRepository.findById(id);
	        return loan.map(l -> modelMapper.map(l, LoanDTO.class)).orElse(null);
	    }

	    @Override
	    public List<LoanDTO> getAllLoans() {
	        List<Loan> loans = loanRepository.findAll();
	        return loans.stream()
	                    .map(loan -> modelMapper.map(loan, LoanDTO.class))
	                    .collect(Collectors.toList());
	    }

	    @Override
	    public LoanDTO saveLoan(LoanDTO loanDTO) {
	    	com.example.demo.entitiy.Book book =bookRepository.findById(loanDTO.getBook().getId()).orElse(null);
	    	
	    	Member member= memberRepository.findById(loanDTO.getMember().getId()).orElse(null);
	        Loan loan = modelMapper.map(loanDTO, Loan.class);	        
	        loan.setBook(book);
	        loan.setMember(member);
	        
	        
	        
//	        if(LoanDTO.getBook()!=null&& LoanDTO.getBookId() !=null) {
//	        	Optional<Book> bookOptional =bookRepository.findById(LoanDTO.getBook().getBookId());
//	        	bookOptional.ifPresent(loan::setBook);
//	        }
	       
	        
	        Loan savedLoan = loanRepository.save(loan);
	        
	        return modelMapper.map(savedLoan, LoanDTO.class);
	    }

	    @Override
	    public LoanDTO updateLoan(Long id, LoanDTO loanDTO) {
	        if (loanRepository.existsById(id)) {
	            Loan loan = modelMapper.map(loanDTO, Loan.class);
	            loan.setId(id);
	            Loan updatedLoan = loanRepository.save(loan);
	            return modelMapper.map(updatedLoan, LoanDTO.class);
	        }
	        return null;
	    }

	    @Override
	    public void deleteLoan(Long id) {
	        loanRepository.deleteById(id);
	    }
	}
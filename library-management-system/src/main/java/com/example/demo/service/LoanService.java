package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.LoanDTO;
import com.example.demo.entitiy.Loan;

public interface LoanService {
	LoanDTO getLoanById(Long id);
    List<LoanDTO> getAllLoans();
    LoanDTO saveLoan(LoanDTO loanDTO);
    LoanDTO updateLoan(Long id, LoanDTO loanDTO);
    void deleteLoan(Long id);
}
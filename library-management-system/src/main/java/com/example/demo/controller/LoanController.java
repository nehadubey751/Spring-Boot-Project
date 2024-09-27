package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoanDTO;
import com.example.demo.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

	 @Autowired
	    private LoanService loanService;

	    @GetMapping("/{id}")
	    public ResponseEntity<LoanDTO> getLoanById(@PathVariable Long id) {
	        LoanDTO loanDTO = loanService.getLoanById(id);
	        return loanDTO != null ? ResponseEntity.ok(loanDTO) : ResponseEntity.notFound().build();
	    }

	    @GetMapping
	    public ResponseEntity<List<LoanDTO>> getAllLoans() {
	        List<LoanDTO> loans = loanService.getAllLoans();
	        return ResponseEntity.ok(loans);
	    }

	    @PostMapping
	    public ResponseEntity<LoanDTO> createLoan(@RequestBody LoanDTO loanDTO) {
	        LoanDTO createdLoanDTO = loanService.saveLoan(loanDTO);
	        return ResponseEntity.ok(createdLoanDTO);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<LoanDTO> updateLoan(@PathVariable Long id, @RequestBody LoanDTO loanDTO) {
	        LoanDTO updatedLoanDTO = loanService.updateLoan(id, loanDTO);
	        return updatedLoanDTO != null ? ResponseEntity.ok(updatedLoanDTO) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
	        loanService.deleteLoan(id);
	        return ResponseEntity.noContent().build();
	    }
	}
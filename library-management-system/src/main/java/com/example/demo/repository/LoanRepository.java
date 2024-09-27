package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitiy.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	List<Loan> findByMemberId(Long memberId);
}
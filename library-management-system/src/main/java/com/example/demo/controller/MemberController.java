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
import com.example.demo.dto.MemberDTO;
import com.example.demo.entitiy.Loan;
import com.example.demo.entitiy.Member;
import com.example.demo.repository.LoanRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.MemberService;


@RestController
@RequestMapping("/api/members")
public class MemberController {
	@Autowired
    private MemberService memberService;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private LoanRepository loanRepository;

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id) {
    	System.out.println(id);
    	
        MemberDTO memberDTO = memberService.getMemberById(id);
        
        return memberDTO != null ? ResponseEntity.ok(memberDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) {
        MemberDTO createdMemberDTO = memberService.saveMember(memberDTO);
        return ResponseEntity.ok(createdMemberDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        MemberDTO updatedMemberDTO = memberService.updateMember(id, memberDTO);
        return updatedMemberDTO != null ? ResponseEntity.ok(updatedMemberDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("member/{id}")
    public List<Loan>  getmemberid(@PathVariable long id) {
    	
    	return loanRepository.findByMemberId(id);
    }
}
package com.example.demo.serviceimple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.MemberDTO;
import com.example.demo.entitiy.Loan;
import com.example.demo.entitiy.Member;
import com.example.demo.repository.LoanRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Service
public class MemberServiceImple implements MemberService{
	 @Autowired
	    private MemberRepository memberRepository;
	 
	 @Autowired
	 private LoanRepository loanRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public MemberDTO getMemberById(Long id) {
	    	
	    	
	        Optional<Member> member = memberRepository.findById(id);
	        return member.map(m -> modelMapper.map(m, MemberDTO.class)).orElse(null);
	    }

	    @Override
	    public List<MemberDTO> getAllMembers() {
	        List<Member> members = memberRepository.findAll();
	        return members.stream()
	                      .map(member -> modelMapper.map(member, MemberDTO.class))
	                      .collect(Collectors.toList());
	    }

	    @Override
	    public MemberDTO saveMember(MemberDTO memberDTO) {
	        Member member = modelMapper.map(memberDTO, Member.class);
	        Member savedMember = memberRepository.save(member);
	        return modelMapper.map(savedMember, MemberDTO.class);
	    }

	    @Override
	    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
	        if (memberRepository.existsById(id)) {
	            Member member = modelMapper.map(memberDTO, Member.class);
	            member.setId(id);
	            Member updatedMember = memberRepository.save(member);
	            return modelMapper.map(updatedMember, MemberDTO.class);
	        }
	        return null;
	    }

	    @Override
	    public void deleteMember(Long id) {
	        memberRepository.deleteById(id);
	    }
	}
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entitiy.Member;

public interface MemberService {
	MemberDTO getMemberById(Long id);
    List<MemberDTO> getAllMembers();
    MemberDTO saveMember(MemberDTO memberDTO);
    MemberDTO updateMember(Long id, MemberDTO memberDTO);
    void deleteMember(Long id);
}
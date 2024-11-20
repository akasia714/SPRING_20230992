package com.example.demo.model.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import com.example.demo.model.domain.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private void validateDuplicateMember(AddMemberRequest request){
        Member findMember = memberRepository.findByEmail(request.getEmail());
        if (findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
    
    public Member saveMember(AddMemberRequest request){
        validateDuplicateMember(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
        return memberRepository.save(request.toEntity());
    }
}

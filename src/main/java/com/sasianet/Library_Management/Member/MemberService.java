package com.sasianet.Library_Management.Member;

import org.springframework.stereotype.Service;

import com.sasianet.Library_Management.Book.Books;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // Constructor injection (no need for @Autowired)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Members> getMember() {
        return memberRepository.findAll();
    }

    public Members getMemberById(int memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    public void addMember(Members member) {
        memberRepository.save(member);
    }
}

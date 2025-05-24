package com.sasianet.Library_Management.Member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasianet.Library_Management.Book.Books;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Members> getMember() {
        return memberService.getMember();
    }

    @GetMapping("/members/id/{memberId}")
    public Members getMember(@PathVariable int memberId) {
        return memberService.getMemberById(memberId);
    }

    @PostMapping("/members")
    public void addMember(@RequestBody Members member) {
        memberService.addMember(member);
    }
        
}

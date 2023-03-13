package com.project.login.controller;

import com.project.login.entity.Member;
import com.project.login.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    //member 정보 (id & pw) 전달 받아서 Member object에 저장하고 call memberService.join(member) method

    private final MemberService memberService;

    @PostMapping("login")
    public String memberLogin(MemberDTO memberDTO) {
        Member member = new Member();

        String memberId = memberDTO.getUserId();
        String password = memberDTO.getPassword();

        try {
            memberService.login(memberId, password);
        } catch (IllegalStateException e) {
            System.out.println("login failed");
            return "redirect:/";
        }
        return "welcome";
    }

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("new")
    public String createForm() {
        return "form";
    }

    @PostMapping("new")
    public String create(MemberDTO memberDTO) {
        Member member = new Member();
        member.setMemberId(memberDTO.getUserId());
        member.setPassword(memberDTO.getPassword());

        //System.out.println(member);

        try {
            memberService.join(member);
        } catch (IllegalStateException e) {
            System.out.println("duplicate member id");
        }
        return "redirect:/";
    }
}

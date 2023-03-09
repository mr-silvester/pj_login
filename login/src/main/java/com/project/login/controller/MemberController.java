package com.project.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    //member 정보 (id & pw) 전달 받아서 Member object에 저장하고 call memberService.join(member) method

//    @PostMapping("login")
//    public String create(MemberForm form) {
//
//        return "welcome";
//    }

    @GetMapping("new")
    public String createForm() {
        return "form";
    }

//    @PostMapping("new")
//    public String create(MemberForm form) {
//
//    }
}

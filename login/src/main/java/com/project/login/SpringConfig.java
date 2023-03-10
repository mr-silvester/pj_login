package com.project.login;


import com.project.login.repository.MemberRepository;
import com.project.login.repository.MemoryRepository;
import com.project.login.service.MemberService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryRepository();
    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository) {
        return new MemberService(memberRepository);
    }
}

package com.project.login;

import com.project.login.repository.JpaRepository;
import com.project.login.repository.MemberRepository;
import com.project.login.repository.MemoryRepository;
import com.project.login.service.MemberService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager entityManager;

    public SpringConfig(DataSource dataSource, EntityManager entityManager) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaRepository(entityManager);
    }

    @Bean
    public MemberService memberService(MemberRepository memberRepository) {
        return new MemberService(memberRepository());
    }
}

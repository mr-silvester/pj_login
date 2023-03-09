package com.project.login;

import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;
import com.project.login.repository.MemoryRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemoryRepositoryTests {
    MemberRepository memberRepository = new MemoryRepository();


    @Test
    void saveAndFindByIdTest() {
        //Given
        Member member = new Member();
        member.setMemberId("test");

        //When
        memberRepository.save(member);

        //Then
        Member result = memberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByMemberIdTest() {
        //Given
        Member member1 = new Member();
        member1.setMemberId("test1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setMemberId("test2");
        memberRepository.save(member2);

        //When
        String result = memberRepository.findByMemberId("test1").get().getMemberId();

        //Then
        assertThat(result).isEqualTo("test1");
    }

    @Test
    void findAll() {
        //Given
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();

        member1.setMemberId("test1");
        member2.setMemberId("test2");
        member3.setMemberId("test3");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        //When
        List<Member> result = memberRepository.findAll();

        //Then
        assertThat(result.size()).isEqualTo(3);
    }
}

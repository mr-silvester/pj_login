package com.project.login;

import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class RepositoryTests {
    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

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
    void findByCreatedDateTest() {
        //Given
        Member member1 = new Member();
        member1.setCreatedDate(new Date(2023, 03, 12));
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setCreatedDate(new Date(2023, 12, 31));
        memberRepository.save(member2);

        Member member3 = new Member();
<<<<<<< HEAD
        member3.setCreatedDate(date2);
=======
        member3.setCreatedDate(new Date(2023, 12, 31));
>>>>>>> origin/23.03.12
        memberRepository.save(member3);

        //When
        List<Member> result = memberRepository.findByCreatedDate(new Date(2023, 12, 31));

        //Then
        assertThat(result.size()).isEqualTo(2);
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

    //------------------------------------------------------------------------------------------------------------//

    /*
    MemoryRepository Tests
    1. save
    2. findById
    3. findByMemberId
    4. findAll
     */

    //tests both save() and findById()
    @Test
    void save2() {
        Member member = new Member();
        member.setMemberId("id1");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByMemberId2() {
        Member member1 = new Member();
        member1.setMemberId("id1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setMemberId("id2");
        memberRepository.save(member2);

        Member result = memberRepository.findByMemberId("id2").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    void findAll2() {
        Member member1 = new Member();
        member1.setMemberId("id1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setMemberId("id2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

package com.project.login;
import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;
import com.project.login.service.MemberService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class MemberServiceTests {
	//@Autowired
	MemberService memberService;
	//@Autowired
	MemberRepository memberRepository;

	/*
	@Test
	public void memberIdValidate() throws Exception {
		//Given
		Member member1 = new Member();
		member1.setMemberId("testId");
		member1.setPassword("a123456");

		Member member2 = new Member();
		member2.setMemberId("testId");

		memberService.join(member1);

		//When
		IllegalStateException e = memberService.memberIdValidate(member2);

		//Then
		assertThat(e.getMessage()).isEqualTo("유효하지 않은 아이디입니다.");
	}


	@Test
	void loginTest() throws Exception {
		//Given
		Member member = new Member();
		member.setMemberId("test");
		member.setPassword("a123456");
		memberRepository.save(member);

		//When
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.login("test", "1234"));

		//Then
		assertThat(e.getMessage()).isEqualTo("아이디와 비밀번호를 다시 확인해주세요."); //예외가 발생해야합니다.
	}
	 */

//------------------------------------------------------------------------------------------------------------//

	/*
	1. ID 중복 확인
	2. 비번 & 비번확인 일치 => html
	3. 이메일 중복 확인 => html
	4. 빈칸 확인
	 */

	@Test
	public void validateID() {
		Member member;
	}

	//------------------------------------------------------------------------------------------------------------//

    /*
    MemoryRepository Tests
    1. save
    2. findById
    3. findByMemberId
    4. findAll
     */
}

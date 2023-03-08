package com.project.login;
import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;
import com.project.login.service.MemberService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class LoginApplicationTests {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void memberIdValidate() {
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
		assertThat(e.getMessage()).isEqualTo("유효하지 않은 아이디입니다."));
		System.out.println(
				"중복여부 : " + memberIdDupCheck + ", " + 		//중복 아이디 사용불가
				"문자제한 : " + memberIdTypCheck + ", " + 		//한글, 특수문자 사용불가
				"길이제한 : " + memberIdLenCheck					//최소2글자, 최대 12글자
		);
	}

	//모든 예외를 illegalStateException으로 통일시켰기 때문에 추후 서로 다른 예외 메시지를 위해 수정이 필요합니다.

	//------------------------------------------------------------------------------------------------------------//

	/*
	1. ID 중복 확인
	2. 비번 & 비번확인 일치 => html
	3. 이메일 중복 확인 => html
	4. 빈칸 확인
	 */

	public void validateID() {
		Member member
	}

}

package com.project.login;
import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;
import com.project.login.service.MemberService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;



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
		member1.setEmail("test@test.com");

		Member member2 = new Member();
		member2.setMemberId("testId");

		memberService.join(member1);

		//When
		IllegalStateException e = memberService.memberIdValidate(member2);

		//Then
		Assert.assertThat(e.getMessage(), is("유효하지 않은 아이디입니다."));
		System.out.println(
				"중복여부 : " + memberIdDupCheck + ", " + 		//중복 아이디 사용불가
				"문자제한 : " + memberIdTypCheck + ", " + 		//한글, 특수문자 사용불가
				"길이제한 : " + memberIdLenCheck					//최소2글자, 최대 12글자
		);
	}

	@Test
	public void passwordValidate() {
		//Given
		Member member = new Member();
		member.setPassword("ab");

		//When
		IllegalStateException e = memberService.passwordValidate(member);

		//Then
		Assert.assertThat(e.getMessage(), is("유효하지 않은 비밀번호입니다."));
		System.out.println(
				"길이제한 : " + passwordLenCheck					//최소 8글자, 최대 12글자
		);
	}

	@Test
	public void emailValidate() {
		//Given
		Member member = new Member();
		member.setEmail("test@test.com");

		//When
		IllegalStateException e = memberService.emailValidate(member);

		//Then
		assertThat(e.getMessage(), is("유효하지 않은 이메일입니다."));
	}

	@Test
	public void emptyCheck() {
		//Given
		Member member = new Member();
		member.setMemberId("test");
		member.setPassword("a123456789");

		//When
		IllegalStateException e = memberService.emptyCheck(member);

		//Then
		assertThat(e.getMessage(), is("요구된 모든 정보를 입력해주세요."));
	}

	//모든 예외를 illegalStateException으로 통일시켰기 때문에 추후 서로 다른 예외 메시지를 위해 수정이 필요합니다.
}

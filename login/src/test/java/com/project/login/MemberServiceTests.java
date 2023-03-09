package com.project.login;
import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;
import com.project.login.repository.MemoryRepository;
import com.project.login.service.MemberService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class MemberServiceTests {
	MemberService memberService = new MemberService();
	MemberRepository memberRepository = new MemoryRepository();
/*
	@Test
	public void validateDuplicateMemberIdTest() throws Exception {
		//Given
		Member member1 = new Member();
		member1.setMemberId("test");
		member1.setPassword("a123456");

		Member member2 = new Member();
		member2.setMemberId("test");

		memberRepository.save(member1);

		//When
		IllegalStateException e = memberService.validateDuplicateMemberId(member2);

		//Then
		assertThat(e.getMessage()).isEqualTo("이미 사용 중인 아이디입니다.");
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
		assertThat(e.getMessage()).isEqualTo("아이디와 비밀번호를 다시 확인해주세요.");
	}
*/

//------------------------------------------------------------------------------------------------------------//

	/*
	1. ID 중복 확인
	2. 비번 & 비번확인 일치 => html
	3. 이메일 중복 확인 => html
	4. 빈칸 확인
	 */

//	@Test
//	public void validateID() {
//		Member member1 = new Member();
//		member1.setMemberId("1");
//
//		Member member2 = new Member();
//		member2.setMemberId("1");
//
//		memberService.join(member1);
//
//		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); //예외가 발생해야 한다.
//		//will call "validateDuplicateMemberId()" in join() and throw exception there
//		assertThat(e.getMessage()).isEqualTo("이미 사용 중인 아이디입니다.");
//	}


}

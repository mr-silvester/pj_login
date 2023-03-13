package com.project.login.service;

import com.project.login.entity.Member;
import com.project.login.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMemberId(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMemberId(Member member) {
        memberRepository.findByMemberId(member.getMemberId())
                .ifPresent(e -> {
                    throw new IllegalStateException("이미 사용 중인 아이디입니다.");
                }
        );
    }

    public Member findMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.get();
    }
    public Long login(String memberId, String password) {
        Optional<Member> member = memberRepository.findByMemberId(memberId);
        member.ifPresentOrElse(m -> {
            Boolean pass = m.getPassword().equals(password);
            if (!pass) {
                throw new IllegalStateException("아이디와 비밀번호가 일치하지 않습니다.");
            }
        }, () -> {
            throw new IllegalStateException("존재하지 않는 아이디입니다.");
        });
        return member.get().getId();
    }
}

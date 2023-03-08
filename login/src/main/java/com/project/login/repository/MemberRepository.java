package com.project.login.repository;

import com.project.login.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findById(Long id);
    public Optional<Member> findByMemberId(String MemberId);
    public List<Member> findAll(String MemberId);
}

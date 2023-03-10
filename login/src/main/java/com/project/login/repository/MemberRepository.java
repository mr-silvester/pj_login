package com.project.login.repository;

import com.project.login.entity.Member;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findById(Long id);
    public Optional<Member> findByMemberId(String memberId);
    public List<Member> findByCreatedDate(Date createdDate);
    public List<Member> findAll();
    public void clearStore();
}

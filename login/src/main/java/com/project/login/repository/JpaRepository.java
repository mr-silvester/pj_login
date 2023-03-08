package com.project.login.repository;

import com.project.login.entity.Member;

import java.util.List;
import java.util.Optional;

public class JpaRepository implements MemberRepository {

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByMemberId(String MemberId) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}

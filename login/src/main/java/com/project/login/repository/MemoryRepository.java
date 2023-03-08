package com.project.login.repository;

import com.project.login.entity.Member;

import java.util.*;

public class MemoryRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 000L;

    private Long id; //PK
    private String memberId;
    private String password;

    //@Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    //@Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    //@Override
    public Optional<Member> findByMemberId(String MemberId) {
        return Optional.ofNullable(store.values().stream().filter(<String memberId>));
    }

    //@Override
    public List<Member> findAll(String MemberId) {
        return new ArrayList<>(store.values());
    }


}

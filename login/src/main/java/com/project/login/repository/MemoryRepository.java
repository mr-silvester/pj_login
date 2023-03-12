package com.project.login.repository;

import com.project.login.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 000L;

    private Long id; //PK
    private String memberId;
    private String password;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        return store.values()
                .stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .findAny();
    }

    @Override
    public List<Member> findByCreatedDate(Date createdDate) {
        return new ArrayList<>(store.values()
                .stream()
                .filter(member -> member.getCreatedDate().equals(createdDate))
                .collect(Collectors.toList()));
    };
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }

}

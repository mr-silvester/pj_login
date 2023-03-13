package com.project.login.repository;

import com.project.login.entity.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JpaRepository implements MemberRepository {
    private final EntityManager entityManager;

    public JpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        Member member = entityManager
                .createQuery("SELECT m FROM Member m WHERE m.memberId=:memberId", Member.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
        return Optional.ofNullable(member);
    }

    @Override
    public List<Member> findByCreatedDate(Date createdDate) {
        return entityManager
                .createQuery("SELECT m FROM Member m WHERE m.createdDate=:createdDate", Member.class)
                .setParameter("createdDate", createdDate)
                .getResultList();
    }
    @Override
    public List<Member> findAll() {
        return entityManager
                .createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    @Override
    public void clearStore() {
    }
}

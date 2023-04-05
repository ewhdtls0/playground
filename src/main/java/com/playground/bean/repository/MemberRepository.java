package com.playground.bean.repository;

import com.playground.bean.domain.Member;

import java.util.List;

public interface MemberRepository {

    Member findMember(Long userId);

    int addMember(Member member);

    List<Member> findAllMember();
}

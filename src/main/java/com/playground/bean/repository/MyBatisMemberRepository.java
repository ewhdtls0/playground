package com.playground.bean.repository;

import com.playground.bean.domain.Member;
import com.playground.mapper.MemberMapper;

import java.util.List;

public class MyBatisMemberRepository implements MemberRepository{

    private final MemberMapper memberMapper;

    public MyBatisMemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Member findMember(Long userId) {
        return null;
    }

    @Override
    public int addMember(Member member) {
        return memberMapper.insertMember(member);
    }

    @Override
    public List<Member> findAllMember() {
        return null;
    }
}

package com.playground.bean.repository;

import com.playground.bean.domain.Member;

import java.util.*;

public class StoreMemberRepository implements MemberRepository {

    private Long sequence = 0L;

    private Map<Long, Member> store = new HashMap<>();

    /**
     * 멤버 조회
     * @param userId
     * @return 멤버 객체
     */
    @Override
    public Member findMember(Long userId) {
        Member member = store.get(userId);

        return member;
    }

    /**
     * 멤버 저장
     * @param member
     * @return 멤버 객체
     */
    public int addMember(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        Member addedMember = store.get(member.getId());

        if(addedMember != null) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 모든 멤버 조회
     * @return List<멤버 객체>
     */
    public List<Member> findAllMember() {
        ArrayList<Member> members = new ArrayList<>(store.values());

        return members;
    }

    /**
     * 스토어 비우기
     */
    public void clearStore() {
        store.clear();
    }
}

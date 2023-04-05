package com.playground.bean.service;

import com.playground.bean.domain.Member;
import com.playground.bean.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 멤버 조회
     * @param userId 멤버 ID
     * @return member 멤버 객체 반환
     */
    public Member getMember(Long userId) {
        return memberRepository.findMember(userId);
    }

    /**
     * 멤버 등록
     * @param member
     * @return 0 or 1, 미등록, 등록
     */
    public int addMember(Member member) {
        return memberRepository.addMember(member);
    }

    /**
     * 모든 멤버 조회
     * @return List<멤버 객체>
     */
    public List<Member> findAllMember() {
        return memberRepository.findAllMember();
    }


}

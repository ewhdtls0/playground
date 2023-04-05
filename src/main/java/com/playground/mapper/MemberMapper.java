package com.playground.mapper;

import com.playground.bean.domain.Member;

public interface MemberMapper {

    /**
     * ID로 멤버 조회
     * @param id
     * @return Member 객체
     */
    Member selectMemberById(Long id);

    /**
     * 멤버 저장
     * @param member
     * @return 0 or 1
     */
    int insertMember(Member member);
}

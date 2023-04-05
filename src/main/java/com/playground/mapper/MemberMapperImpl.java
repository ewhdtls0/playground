package com.playground.mapper;

import com.playground.bean.domain.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberMapperImpl implements MemberMapper{

    private final SqlSession sqlSession;

    public MemberMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Member selectMemberById(Long id) {
        return sqlSession.selectOne("selectMemberById");
    }

    @Override
    public int insertMember(Member member) {
        return sqlSession.insert("insertMember", member);
    }
}

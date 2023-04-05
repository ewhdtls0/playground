package com.playground.bean;

import com.playground.bean.repository.MyBatisMemberRepository;
import com.playground.bean.repository.MemberRepository;
import com.playground.bean.repository.StoreMemberRepository;
import com.playground.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.playground")
public class RepositoryConfig {

    /**
     * 인-메모리 DB
     * @return Store 리포지토리(memory)
     */
    @Bean
    @Primary
    public MemberRepository storeMemberRepository(){
        return new StoreMemberRepository();
    }

    /**
     * MyBatis
     * @param memberMapper
     * @return MyBatis 기술 사용한 리포지토리
     */
    @Bean
    @Qualifier("MyBatis")
    public MemberRepository mybatisMemberRepository(MemberMapper memberMapper) {
        return new MyBatisMemberRepository(memberMapper);
    }

    @Bean
    public MemberMapper memberMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(MemberMapper.class);
    }
}

package com.playground.bean;

import com.playground.bean.domain.Member;
import com.playground.bean.domain.enums.Gender;
import com.playground.bean.repository.MemberRepository;
import com.playground.bean.service.MemberService;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    @Qualifier("MyBatis")
    private MemberRepository memberRepository;

    @Autowired
    private SqlSession sqlSession;

    @Test
    @DisplayName("어떠한 Repository 주입 받더라도 멤버가 저장되고 조회된다.")
    public void memberTest() {
        Member member = new Member();

        member.setName("김갑환");
        member.setAge(28);
        member.setEmail("aaa@bbb.com");
        member.setGender(Gender.F);

        int result = memberRepository.addMember(member);

        Assertions.assertThat(result).isEqualTo(1);
    }
}

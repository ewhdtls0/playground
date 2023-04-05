package com.playground.bean.domain;


import com.playground.bean.domain.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;

    private String name;

    private int age;

    private String email;

    private Gender gender;

}

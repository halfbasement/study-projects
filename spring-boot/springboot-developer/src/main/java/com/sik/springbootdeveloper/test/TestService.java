package com.sik.springbootdeveloper.test;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {


    private MemberRepository t;

    public TestService(MemberRepository t) {
        this.t = t;
    }

    public List<Member> getAllMembers(){
        return t.findAll();
    }
}

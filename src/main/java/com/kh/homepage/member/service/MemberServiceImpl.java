package com.kh.homepage.member.service;

import com.kh.homepage.member.model.Member;
import com.kh.homepage.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member loginMember(Member m) {
        return memberRepository.findByUserIdAndUserPwd(m.getUserId(), m.getUserPwd());
    }

    @Override
    public Member insertMember(Member m) {
        return memberRepository.save(m);
    }
}

package com.kh.homepage.member.service;

import com.kh.homepage.member.model.Member;

public interface MemberService {

    Member loginMember(Member m);

    Member insertMember(Member m);
}

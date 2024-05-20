package com.kh.homepage.member.repository;

import com.kh.homepage.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByUserIdAndUserPwd(String userId, String userPwd);
}

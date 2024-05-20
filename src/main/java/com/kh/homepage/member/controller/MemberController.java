package com.kh.homepage.member.controller;

import com.kh.homepage.member.model.Member;
import com.kh.homepage.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    /** 생성자 주입 방식 **/
    // - 안정성과 불변성 보장을 위해 final 키워드 사용 ( 싱글톤 패턴 / 한 번 초기화되면 변경할 수 없음)
    private final MemberService mService;
    
    @Autowired
    public MemberController(MemberService mService) {
        this.mService = mService;
    }

    @RequestMapping("/enrollForm.me")
    public String viewEnrollForm() {
        return "member/enrollForm";
    }

    @RequestMapping("/myPage.me")
    public String viewMyPage() {
        return "member/myPage";
    }

    @RequestMapping("/insert.me")
    public String insertMember(Member newUser
                            , Model model) {
        Member m = mService.insertMember(newUser);
        if(m.getUserNo() == 0) {
            model.addAttribute("errorMsg", "회원 가입 실패");
            return "common/errorPage";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/login.me")
    public String loginMember(Member m
            , Model model
            , HttpSession session) {
        Member user = mService.loginMember(m);

        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/";
        } else {
            model.addAttribute("errorMsg", "로그인 실패");
            return "common/errorPage";
        }
    }

    @RequestMapping("/logout.me")
    public String logoutMember(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}

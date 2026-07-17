package com.login.boot10.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.login.boot10.member.domain.Member;
import com.login.boot10.member.repository.MemberRepository;
import com.login.boot10.web.SessionManager;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final MemberRepository memberRepository;
	private final SessionManager sessionManager;

    // @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/")
    public String homeLoginV1(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
    	if (memberId == null) {
    		return "home";
    	}
    	
    	// 로그인
    	Member loginMember = memberRepository.findById(memberId);
    	if (loginMember == null) {
    		return "home";
    	}
    	
    	model.addAttribute("member", loginMember);
    	return "loginHome";
    }
    
    @GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model) {
    	// 세션 관리자에 저장된 회원 정보 조회
    	Member member = (Member)sessionManager.getSession(request);
    	
    	if (member == null) {
    		return "home";
    	}
    	
    	// 로그인
    	model.addAttribute("member", member);
    	return "loginHome";
    }
    
}

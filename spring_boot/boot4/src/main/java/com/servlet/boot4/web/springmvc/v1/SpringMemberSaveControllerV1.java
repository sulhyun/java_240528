package com.servlet.boot4.web.springmvc.v1;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.servlet.boot4.domain.Member;
import com.servlet.boot4.repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberSaveControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/springmvc/v1/members/save")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		ModelAndView mv = new ModelAndView("save");
		//mv.getModel().put("member", member);
		mv.addObject("member", member);
		return mv;
	}
	
}

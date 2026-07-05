package com.servlet.boot4.web.springmvc.v2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.servlet.boot4.domain.Member;
import com.servlet.boot4.repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/form")
	public ModelAndView form() {
		return new ModelAndView("form");
	}
	
	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		ModelAndView mv = new ModelAndView("save");
		mv.addObject("member", member);
		return mv;
	}
	
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Member> members = memberRepository.findAll();
		
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("members", members);
		return mv;
	}
	
}

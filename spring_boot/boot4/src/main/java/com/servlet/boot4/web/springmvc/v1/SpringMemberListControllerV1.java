package com.servlet.boot4.web.springmvc.v1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.servlet.boot4.domain.Member;
import com.servlet.boot4.repository.MemberRepository;

@Controller
public class SpringMemberListControllerV1 {

	private MemberRepository memberRepository = MemberRepository.getInstance();
	
	@RequestMapping("/springmvc/v1/members/list")
	public ModelAndView process() {
		List<Member> members = memberRepository.findAll();
		
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("members", members);
		return mv;
	}
}

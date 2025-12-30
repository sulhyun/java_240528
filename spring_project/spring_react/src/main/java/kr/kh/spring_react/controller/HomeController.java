package kr.kh.spring_react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.kh.spring_react.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
	    return "/main/home";
	}
	
}

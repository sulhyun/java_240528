package kr.kh.spring_react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring_react.model.vo.MemberVO;
import kr.kh.spring_react.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("/ : 메인 페이지");
		model.addAttribute("title", "메인");
	    return "/main/home";
	}
	
	@GetMapping("/guest/signup")
	public String signup(Model model) {
		System.out.println("/guest/signup : GET");
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	
	@PostMapping("/guest/signup")
	public String signupPost(Model model, MemberVO member) {
		System.out.println("/guest/signup : POST");
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "회원가입 성공");
		}else {
			model.addAttribute("url", "/guest/signup");
			model.addAttribute("msg", "회원가입 실패");
		}
		return "/util/msg";
	}
	
}

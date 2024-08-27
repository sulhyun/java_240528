package kr.kh.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		if(memberService.signup(member)) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "회원가입 성공!!");
		}else {
			model.addAttribute("url", "/signup");
			model.addAttribute("msg", "회원가입 실패!!");
		}
		return "/main/message";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		if(memberService.login(member)) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인 성공!!");
		}else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인 실패!!");
		}
		return "/main/message";
	}
}

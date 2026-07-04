package kr.kh.spring_react.controller;

import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/signup")
	public String signup(Model model) {
		System.out.println("/signup : GET");
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		System.out.println("/signup : POST");
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
	
	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("/login : GET");
		model.addAttribute("title", "로그인");
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member, HttpSession session) {
		System.out.println("/login : POST");
		MemberVO user = memberService.login(member);
		session.setAttribute("user", user);
		if(user != null) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인 성공");
		}else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인 실패");
		}
		return "/util/msg";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		System.out.println("/logout : GET");
		session.removeAttribute("user");
		model.addAttribute("url", "/");
		model.addAttribute("msg", "로그아웃 성공");
		return "/util/msg";
	}
	
}

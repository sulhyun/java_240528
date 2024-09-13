package kr.kh.spring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring1.model.vo.MemberVO;
import kr.kh.spring1.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("매인화면");
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup() {
		log.info("signup:get");
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		log.info("signup:post");
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원가입 성공");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입 실패");
			model.addAttribute("url", "/signup");
		}
		return "/main/message";
	}

}

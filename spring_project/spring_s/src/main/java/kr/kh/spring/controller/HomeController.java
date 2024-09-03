package kr.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	// private MemberSerivce memberService = new MemberServiceImp();
	@Autowired
	private MemberService memberService;
	
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	// 화면에서 보낸 정보를 객체로 받는 경우 실행 과정
	// 1. 해당 클래스의 기본 생성자가 호출 
	// 2. 화면에서 보낸 name과 같은 멤버변수들의 setter 호출해서 값을 변경
	public String home(Model model, PersonDTO person) {
		model.addAttribute("name", "홍길동");
		System.out.println(person);
		return "/main/home";
	}
	
	// @RequestMapping(value = "/signup", method = RequestMethod.GET)
	@GetMapping("/signup")
	public String signup() {
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {
		boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원가입 완료!!");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입 실패!!");
			model.addAttribute("url", "/signup");
		}
		return "/main/message";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member, HttpSession session) {
		MemberVO user = memberService.login(member);
		if(user != null) {
			user.setAutoLogin(member.isAutoLogin());
			model.addAttribute("msg", "로그인 성공!!");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인 실패!!");
			model.addAttribute("url", "/login");
		}
		model.addAttribute("user", user);
		return "/main/message";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			user.setMe_cookie(null);
			memberService.updateMemberCookie(user);
		}
		// 세션에 있는 user를 제거
		session.removeAttribute("user");
		model.addAttribute("msg", "로그아웃 성공!!");
		model.addAttribute("url", "/");
		return "/main/message";
	}
	
	// @CrossOrigin(origins = "*") // 모든 사이트들이 해당 URL에 데이터를 요청하도록 허락
	@ResponseBody
	@GetMapping("/check/id")
	public boolean checkId(@RequestParam("id")String id) {
		boolean res = memberService.checkId(id);
		return res;
	}
}

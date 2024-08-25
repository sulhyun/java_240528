package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberServiceImp();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 페이지로 오기 전 URL을 가져옴
		String url = request.getHeader("Referer");
		//URL이 있거나 /login 아니면 세션에 URL을 저장
		if(url != null && !url.contains("/login")) {
			request.getSession().setAttribute("prevUrl", url);
		}
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에서 입력한 아이디, 비번을 이용해서 회원 정보를 가져오고, 가져온 회원 정보를 세션에 저장
		// 1. 화면에서 입력한 아이디, 비번을 가져옴
		String me_id = request.getParameter("me_id");
		String me_pw = request.getParameter("me_pw");
		// 2. 아이디, 비번을 이용해서 회원 정보를 가져옴
		MemberVO member = new MemberVO(me_id, me_pw, "");
		MemberVO user = memberService.login(member);
		// 3. 가져온 회원 정보를 세션에 저장
		request.getSession().setAttribute("user", user);
		if(user != null) {
			request.setAttribute("msg", "로그인 성공!!");
			request.setAttribute("url", "/");
			//자동로그인을 체크했으면
			String auto = request.getParameter("auto");
			if(auto != null && auto.equals("true")) {
			//쿠키를 생성하고 DB에 쿠키와 만료시간을 저장
			Cookie cookie = memberService.createCookie(user, request);
			response.addCookie(cookie);
			}
		}else {
			request.setAttribute("msg", "로그인 실패!!");
			request.setAttribute("url", "/login");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}

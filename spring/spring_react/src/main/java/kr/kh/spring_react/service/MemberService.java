package kr.kh.spring_react.service;

import kr.kh.spring_react.model.vo.MemberVO;

public interface MemberService {

	public boolean signup(MemberVO member);

	public MemberVO login(MemberVO member);
	
}

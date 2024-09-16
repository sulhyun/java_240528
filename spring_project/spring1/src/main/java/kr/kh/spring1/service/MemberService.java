package kr.kh.spring1.service;

import kr.kh.spring1.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);
	

}

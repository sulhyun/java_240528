package kr.kh.spring_react.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring_react.model.vo.MemberVO;

public interface MemberDAO {

	public boolean insertMember(@Param("me") MemberVO member);
	
}

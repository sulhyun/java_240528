package kr.kh.spring1.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring1.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("m")MemberVO member);

}

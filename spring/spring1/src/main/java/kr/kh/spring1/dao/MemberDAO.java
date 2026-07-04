package kr.kh.spring1.dao;

import kr.kh.spring1.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(MemberVO member);

	MemberVO selectMember(String me_id);
	
}

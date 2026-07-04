package db.community.dao;

import org.apache.ibatis.annotations.Param;

import db.community.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("id")String id);

	void updateFail(@Param("id")String string, @Param("add")int add);

	boolean insetMember(@Param("id")String id, @Param("pw")String pw, @Param("email")String email);

}

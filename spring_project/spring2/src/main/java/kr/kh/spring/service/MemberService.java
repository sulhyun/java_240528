package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		try {
			memberDao.insertMember(member);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}

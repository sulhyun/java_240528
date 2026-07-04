package kr.kh.spring1.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring1.dao.MemberDAO;
import kr.kh.spring1.model.vo.MemberVO;

@Service
public class MemverServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		if(!checkRegex(member.getMe_id(), "^\\w{6,13}$")) {
			return false;
		}
		if(!checkRegex(member.getMe_pw(), "^[a-zA-Z0-9!@#$]{6,15}$")) {
			return false;
		}
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		
		try {
			return memberDao.insertMember(member);
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean checkRegex(String data, String regex) {
		if(data != null && Pattern.matches(regex, data)) {
			return true;
		}
		return false;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null) {
			return null;
		}
		boolean res = passwordEncoder.matches(member.getMe_pw(), user.getMe_pw());
		if(res) {
			return user;
		}
		return null;
	}
}

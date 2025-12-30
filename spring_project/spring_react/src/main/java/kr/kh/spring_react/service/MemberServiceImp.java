package kr.kh.spring_react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring_react.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;

	@Override
	public String getEmail(String id) {
		return memberDao.getEmail(id);
	}
	
}

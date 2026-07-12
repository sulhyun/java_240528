package com.login.boot10.member.service;

import org.springframework.stereotype.Service;

import com.login.boot10.member.domain.Member;
import com.login.boot10.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final MemberRepository memberRepository;
	
	/**
	 * 
	 * @param loginId
	 * @param password
	 * @return null이면 로그인 실패
	 */
	public Member login(String loginId, String password) {
		return memberRepository.findByLoginId(loginId)
				.filter(m -> m.getPassword().equals(password))
				.orElse(null);
	}

}

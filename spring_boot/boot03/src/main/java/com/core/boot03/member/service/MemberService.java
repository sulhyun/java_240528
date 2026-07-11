package com.core.boot03.member.service;

import com.core.boot03.member.domain.Member;

public interface MemberService {

	void join(Member member);
	
	Member findMember(Long memberId);
	
}

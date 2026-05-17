package com.core.boot3.member.service;

import com.core.boot3.member.domain.Member;

public interface MemberService {

	void join(Member member);
	
	Member findMember(Long memberId);
	
}

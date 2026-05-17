package com.core.boot3.member.repository;

import com.core.boot3.member.domain.Member;

public interface MemberRepository {

	void save(Member member);
	
	Member findById(Long memberId);
	
}

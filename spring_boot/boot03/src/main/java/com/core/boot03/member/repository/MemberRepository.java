package com.core.boot03.member.repository;

import com.core.boot03.member.domain.Member;

public interface MemberRepository {

	void save(Member member);
	
	Member findById(Long memberId);
	
}

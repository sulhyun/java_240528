package com.core.boot3.member.service;

import com.core.boot3.member.domain.Member;
import com.core.boot3.member.repository.MemberRepository;
import com.core.boot3.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}

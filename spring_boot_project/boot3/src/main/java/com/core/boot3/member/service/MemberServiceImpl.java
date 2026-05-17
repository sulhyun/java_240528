package com.core.boot3.member.service;

import com.core.boot3.member.domain.Member;
import com.core.boot3.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}

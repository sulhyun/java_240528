package com.core.boot3.member.service;

import org.springframework.stereotype.Component;

import com.core.boot3.member.domain.Member;
import com.core.boot3.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}
	
	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}

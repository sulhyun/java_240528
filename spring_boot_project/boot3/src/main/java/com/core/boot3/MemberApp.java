package com.core.boot3;

import com.core.boot3.member.domain.Grade;
import com.core.boot3.member.domain.Member;
import com.core.boot3.member.repository.MemoryMemberRepository;
import com.core.boot3.member.service.MemberService;
import com.core.boot3.member.service.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		
		MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
		Member member = new Member(1L, "MemberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
		
	}
}

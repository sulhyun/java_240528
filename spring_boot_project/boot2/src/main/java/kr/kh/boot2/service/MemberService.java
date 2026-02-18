package kr.kh.boot2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.kh.boot2.domain.Member;
import kr.kh.boot2.repository.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/**
	 * 회원가입
	 */
	public long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	} // 중복 회원 검증
	
	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(long memberId) {
		return memberRepository.findById(memberId);
	}
}

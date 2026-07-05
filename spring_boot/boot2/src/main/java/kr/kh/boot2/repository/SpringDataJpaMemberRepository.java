package kr.kh.boot2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.kh.boot2.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	@Override
	Optional<Member> findByName(String name);
}

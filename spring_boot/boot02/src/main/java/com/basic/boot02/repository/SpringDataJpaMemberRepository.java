package com.basic.boot02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.boot02.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	@Override
	Optional<Member> findByName(String name);
	
}

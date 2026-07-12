package com.login.boot10;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.login.boot10.item.domain.Item;
import com.login.boot10.item.repository.ItemRepository;
import com.login.boot10.member.domain.Member;
import com.login.boot10.member.repository.MemberRepository;

import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
        
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("테스터");
        memberRepository.save(member);
    }

}
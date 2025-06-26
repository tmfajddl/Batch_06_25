package com.koreait.exam.batch_25_06.app.member.service;

import com.koreait.exam.batch_25_06.app.cash.entity.CashLog;
import com.koreait.exam.batch_25_06.app.cash.service.CashService;
import com.koreait.exam.batch_25_06.app.member.entity.Member;
import com.koreait.exam.batch_25_06.app.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final CashService cashService;

    public MemberService(MemberRepository memberRepository, CashService cashService) {
        this.memberRepository = memberRepository;
        this.cashService = cashService;
    }

    @Transactional
    public Member join(String username, String password, String email) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .email(email).build();

        memberRepository.save(member);

        return member;
    }

    @Transactional
    public void addCash(Member member, long price, String eventType) {

        CashLog cashLog = cashService.addCash(member, price, eventType);

        long newRestCash = member.getRestCash() + cashLog.getPrice();

        member.setRestCash(newRestCash);

        memberRepository.save(member);
    }

    public long getRestCash(Member member) {

        return member.getRestCash();
    }
}

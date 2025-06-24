package com.koreait.exam.batch_25_06.app.member.reposistory;

import com.koreait.exam.batch_25_06.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {

}

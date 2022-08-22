package hello.hellospring.repositoty;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 멤버 등록
    Member save(Member member);

    // 멤버 조회
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

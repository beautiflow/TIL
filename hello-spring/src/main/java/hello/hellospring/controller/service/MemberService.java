package hello.hellospring.controller.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repositoty.MemberRepository;
import hello.hellospring.repositoty.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        // 중복 회원 검증
        vaildateDuplicateMember(member);

        // 저장
        memberRepository.save(member);

        // return
        return member.getId();
    }

    // 중복 회원 검증
    private void vaildateDuplicateMember(Member member) {
        // 이름 ???
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}


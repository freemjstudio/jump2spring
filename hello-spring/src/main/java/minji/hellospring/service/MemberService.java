package minji.hellospring.service;

import minji.hellospring.domain.Member;
import minji.hellospring.repository.MemberRepository;
import minji.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service 에는 비즈니스 관련 로직을 넣어야 한다.
// Spring Container 에 memberservice 를 등록해줌

public class MemberService {
    private final MemberRepository memberRepository;
    // 생성자 호출

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    회원 가입 - id 를 반환한다. (임의로 지정)
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

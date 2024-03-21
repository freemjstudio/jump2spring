package minji.hellospring.repository;

import minji.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장하는 저장소
public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // id 로 검색, Optional 로 감싸서 Null 값 반환
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 회원 리스트
}

package minji.hellospring.repository;

import minji.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // 실무에서는 동시성 문제가 있을 수 있으므로 공유되는 변수의 경우에는 Concurrent HashMap 을 사용해야 한다.
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 고려 해서 autumn long 처리 등을 해주어야 함 !
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // member Id 값을 셋팅
        store.put(member.getId(), member); // store 에 저장하기

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

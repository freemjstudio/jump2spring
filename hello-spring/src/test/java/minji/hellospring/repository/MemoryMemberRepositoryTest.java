package minji.hellospring.repository;

import minji.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

// 순서와 상관없이 메소드 따로 돌게 설계해야함 ! 순서에 의존적으로 설계하면 안됨
class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    // AfterEach 메소드가 실행이 끝날 때마다 어떤 동작을 하게 됨 callback method 라고 보면 됨 !
    @AfterEach
    public void afterEach() {

    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // Optional 값에서 바로 get() 해오기
        // System.out.println("result = " + (result == member));

        // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); // static import 시켰음
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("minji");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();
        assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

//        Member member3 = new Member();
//        member3.setName("spring3");
//        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

package minji.hellospring;

import minji.hellospring.domain.Member;
import minji.hellospring.repository.MemberRepository;
import minji.hellospring.repository.MemoryMemberRepository;
import minji.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

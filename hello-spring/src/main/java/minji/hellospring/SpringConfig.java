package minji.hellospring;

import minji.hellospring.domain.Member;
import minji.hellospring.repository.JdbcMemberRepository;
import minji.hellospring.repository.MemberRepository;
import minji.hellospring.repository.MemoryMemberRepository;
import minji.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource; // spring bean 이 관리한다.

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}

package minji.hellospring.controller;

import minji.hellospring.domain.Member;
import minji.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// spring 이 MemberController 객체를 생성해서 넣어둠
@Controller
public class MemberController {
    // 하나만 생성하고 공유해서 사용. spring container 에 등록한다.
    private final MemberService memberService;

    // Autowired -> spring member service : 의존 관계 주입
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
}

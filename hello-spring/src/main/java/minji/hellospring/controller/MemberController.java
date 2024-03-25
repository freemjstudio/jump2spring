package minji.hellospring.controller;

import org.springframework.ui.Model;
import minji.hellospring.domain.Member;
import minji.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        // member list 자체를 다 model 에 담아서 화면에 넘긴다.
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

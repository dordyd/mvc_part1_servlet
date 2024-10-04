package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemoryMemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor
public class MemberListControllerV4 implements ControllerV4 {
    private final MemoryMemberRepository memberRepository = MemoryMemberRepository.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);

        return "members";
    }
}

package spring_basic.core;

import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemberServiceImpl;

public class MemberApp
{
    public static void main(String[] args)
    {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new member = " + member.getName());
    }
}

package spring_basic.core;

import spring_basic.core.discount.DiscountPolicy;
import spring_basic.core.discount.FixDiscountPolicy;
import spring_basic.core.member.MemberRepository;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemberServiceImpl;
import spring_basic.core.member.MemoryMemberRepository;
import spring_basic.core.order.OrderService;
import spring_basic.core.order.OrderServiceImpl;

public class AppConfig
{
    public MemberService memberService()
    {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService()
    {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public static DiscountPolicy discountPolicy()
    {
        return new FixDiscountPolicy();
    }

    public static MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }
}

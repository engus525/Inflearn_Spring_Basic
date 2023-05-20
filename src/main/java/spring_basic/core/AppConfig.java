package spring_basic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_basic.core.discount.DiscountPolicy;
import spring_basic.core.discount.FixDiscountPolicy;
import spring_basic.core.discount.RateDiscountPolicy;
import spring_basic.core.member.MemberRepository;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemberServiceImpl;
import spring_basic.core.member.MemoryMemberRepository;
import spring_basic.core.order.OrderService;
import spring_basic.core.order.OrderServiceImpl;

@Configuration
public class AppConfig
{
    @Bean
    public MemberService memberService()
    {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService()
    {
        System.out.println("AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy()
    {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository()
    {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
}

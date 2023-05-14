package spring_basic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemberServiceImpl;
import spring_basic.core.order.Order;
import spring_basic.core.order.OrderService;
import spring_basic.core.order.OrderServiceImpl;

public class OrderApp
{
    public static void main(String[] args)
    {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}

package spring_basic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic.core.AppConfig;
import spring_basic.core.AutoConfig;
import spring_basic.core.discount.DiscountPolicy;
import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemberServiceImpl;

public class OrderServiceTest
{
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach()
    {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder() throws Exception
    {
        //given
        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);

        //when

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
    
    @Test
    public void autowiredFieldName() throws Exception
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
    }
}

package spring_basic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemberServiceImpl;

public class OrderServiceTest
{
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

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
}

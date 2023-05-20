package spring_basic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_basic.core.discount.FixDiscountPolicy;
import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberRepository;
import spring_basic.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest
{
    @Test
    public void createOrder() throws Exception
    {
        //given
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"A", Grade.VIP));

        //when
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "item", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
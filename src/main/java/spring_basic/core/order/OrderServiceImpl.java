package spring_basic.core.order;

import spring_basic.core.discount.DiscountPolicy;
import spring_basic.core.discount.FixDiscountPolicy;
import spring_basic.core.discount.RateDiscountPolicy;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberRepository;
import spring_basic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService
{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //DIP 원칙을 지켰으나 NullPointerException 발생
    private DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice)
    {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}

package spring_basic.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_basic.core.annotation.MainDiscountPolicy;
import spring_basic.core.discount.DiscountPolicy;
import spring_basic.core.discount.FixDiscountPolicy;
import spring_basic.core.discount.RateDiscountPolicy;
import spring_basic.core.member.Member;
import spring_basic.core.member.MemberRepository;
import spring_basic.core.member.MemberService;
import spring_basic.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService
{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy)
    {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice)
    {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //for test
    public MemberRepository getMemberRepository()
    {
        return memberRepository;
    }
}

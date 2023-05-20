package spring_basic.core.discount;

import org.springframework.stereotype.Component;
import spring_basic.core.annotation.MainDiscountPolicy;
import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy
{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price)
    {
        if(member.getGrade() == Grade.VIP) return price*discountPercent/100;
        else return 0;
    }
}

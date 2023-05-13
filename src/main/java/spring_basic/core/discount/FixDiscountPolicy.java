package spring_basic.core.discount;

import spring_basic.core.member.Grade;
import spring_basic.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy
{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price)
    {
        //ENUM type 비교는 ==
        if(member.getGrade() == Grade.VIP) return discountFixAmount;
        else return 0;
    }
}

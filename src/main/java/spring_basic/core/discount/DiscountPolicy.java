package spring_basic.core.discount;

import spring_basic.core.member.Member;

public interface DiscountPolicy
{
    int discount(Member member, int price);
}

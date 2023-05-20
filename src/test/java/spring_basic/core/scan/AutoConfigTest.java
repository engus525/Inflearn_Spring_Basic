package spring_basic.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic.core.AutoConfig;
import spring_basic.core.member.MemberService;

public class AutoConfigTest
{
    @Test
    void basicScan()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);

        MemberService bean = ac.getBean(MemberService.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }


}

package spring_basic.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest
{
    @Test
    void statefulServiceSingletonTest()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int Aprice = statefulService1.order("A", 10000);
        int Bprice = statefulService2.order("B", 20000);

//        int price = statefulService1.getPrice();
        System.out.println("Aprice = " + Aprice);
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
          assertThat(Aprice).isEqualTo(10000);
    }

    static class TestConfig
    {
        @Bean
        public StatefulService statefulService()
        {
            return new StatefulService();
        }
    }
}
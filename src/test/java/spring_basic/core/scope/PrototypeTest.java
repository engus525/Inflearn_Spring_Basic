package spring_basic.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest
{
    @Test
    void prototypeBeanFind()
    {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(Prototype.class);
        System.out.println("Find Bean1");
        Prototype bean1 = ac.getBean(Prototype.class);
        System.out.println("Find Bean2");
        Prototype bean2 = ac.getBean(Prototype.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        assertThat(bean1).isNotSameAs(bean2);
        ac.close();
    }

    @Scope("prototype")
    @Component
    static class Prototype
    {
        @PostConstruct
        public void init()
        {
            System.out.println("Prototype.init");
        }

        @PreDestroy
        public void destroy()
        {
            System.out.println("Prototype.destroy");
        }
    }
}

package spring_basic.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1
{

    @Test
    void prototypeFind()
    {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean = ac.getBean(PrototypeBean.class);
        bean.addCount();
        assertThat(bean.getCount()).isEqualTo(1);

        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        bean1.addCount();
        assertThat(bean.getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUsePrototype()
    {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        ClientBean bean2 = ac.getBean(ClientBean.class);

        int logic1 = bean1.logic();
        assertThat(logic1).isEqualTo(1);

        int logic2 = bean2.logic();
        assertThat(logic2).isEqualTo(2);

    }


    @RequiredArgsConstructor
    static class ClientBean
    {
        private final PrototypeBean prototypeBean;

        public int logic()
        {
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }


    @Scope("prototype")
    @Component
    static class PrototypeBean
    {
        private int count = 0;

        public void addCount()
        {
            count++;
        }

        public int getCount()
        {
            return count;
        }

        @PostConstruct
        public void init()
        {
            System.out.println("Prototype.init " + this);
        }

        @PreDestroy
        public void destroy()
        {
            System.out.println("Prototype.destroy " + this);
        }
    }
}

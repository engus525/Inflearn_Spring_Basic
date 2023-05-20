package spring_basic.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@SpringBootTest
class CoreApplicationTests {

	@Test
	@DisplayName("모든 Bean 조회")
	void findAllBeans()
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
		Map<String, Object> beansOfType = ac.getBeansWithAnnotation(Component.class);
		for (String key : beansOfType.keySet())
		{
			System.out.println("beansOfType.get(key) = " + beansOfType.get(key));
		}
	}
	@Test
	void contextLoads() {
	}

}

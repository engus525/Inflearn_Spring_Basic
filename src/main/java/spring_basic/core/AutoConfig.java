package spring_basic.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "spring_basic.core",
        excludeFilters =
        @ComponentScan.Filter
                (
                        type = FilterType.ANNOTATION,
                        classes = Configuration.class
                )
)
public class AutoConfig
{

}

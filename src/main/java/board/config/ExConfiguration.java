package board.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "board", excludeFilters = @Filter(value = Configuration.class, type = FilterType.ANNOTATION))
@EnableAutoConfiguration
@Retention(RetentionPolicy.RUNTIME)
public @interface ExConfiguration {

}

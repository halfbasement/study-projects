package hello.boot;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//어디에 이 에노테이션을 붙일 수 있는지
@Retention(RetentionPolicy.RUNTIME) // 애노테이션이 언제까지 살아 남아 있을지를 정하는 것 ( 라이프사이클 )
@Documented
@ComponentScan
public @interface MySpringBootApplication {
}

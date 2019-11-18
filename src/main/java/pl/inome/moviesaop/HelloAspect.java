package pl.inome.moviesaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
class HelloAspect {

    @Before("execution(String pl.inome.moviesaop.Hello.sayHello())")
    private void beforeHello() {
        System.out.println("Before Hello");
    }
}

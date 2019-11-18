package pl.inome.moviesaop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class HelloAspect {

    @Around("execution(String pl.inome.moviesaop.Hello.sayHello())")
    private void aroundHello() {
        System.out.println("Around Hello");
    }

//    @Before("execution(String pl.inome.moviesaop.Hello.sayHello())")
//    private void beforeHello() {
//        System.out.println("Before Hello");
//    }
}

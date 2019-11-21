package pl.inome.moviesaop.hello;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
class HelloAspect {

    @Around("@annotation(pl.inome.moviesaop.hello.HelloAnnotation)")
    private void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Hello");
        joinPoint.proceed();
    }

    @Before("@annotation(pl.inome.moviesaop.hello.HelloAnnotation)")
    private void beforeHello() {
        System.out.println("Before Hello");
    }

    @After("@annotation(pl.inome.moviesaop.hello.HelloAnnotation)")
    private void afterHello() {
        System.out.println("After Hello");
    }
}

package pl.inome.moviesaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
class HelloAspect {

    @Around("@annotation(HelloAnnotation)")
    private void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Hello");
        joinPoint.proceed();
    }

    @Before("@annotation(HelloAnnotation)")
    private void beforeHello() {
        System.out.println("Before Hello");
    }

    @After("@annotation(HelloAnnotation)")
    private void afterHello() {
        System.out.println("After Hello");
    }
}

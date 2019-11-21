package pl.inome.moviesaop.hello;

import org.springframework.stereotype.Component;

@Component
class Hello {

    //    @EventListener(ApplicationReadyEvent.class)
    @HelloAnnotation
    public String sayHello() {
        System.out.println("Hello");
        return "Hello";
    }
}

package pl.inome.moviesaop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class Hello {

    @EventListener(ApplicationReadyEvent.class)
    @HelloAnnotation
    public String sayHello() {
        System.out.println("Hello");
        return "Hello";
    }
}

package pl.inome.moviesaop.email;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class EmailAspect {

    @After(value = "@annotation(pl.inome.moviesaop.email.EmailSend)")
    private void sendEmail() {
        System.out.println("email send");
    }

}

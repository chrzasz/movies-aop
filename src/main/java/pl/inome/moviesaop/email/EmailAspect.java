package pl.inome.moviesaop.email;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
class EmailAspect {

    EmailService emailService;

    @Autowired
    public EmailAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @After(value = "@annotation(EmailSend)")
    private void sendEmail() {
        emailService.sendMessage("emailt407@gmail.com");
    }
}

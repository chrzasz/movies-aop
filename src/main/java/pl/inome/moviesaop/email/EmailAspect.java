package pl.inome.moviesaop.email;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.inome.moviesaop.service.MovieService;

@Aspect
@Component
class EmailAspect {

    private JavaMailSender emailSender;
    private MovieService movieService;

    @Autowired
    public EmailAspect(JavaMailSender emailSender, MovieService movieService) {
        this.emailSender = emailSender;
        this.movieService = movieService;
    }

    public EmailAspect(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @After(value = "@annotation(EmailSend)")
    private void sendEmail() {
        Thread thread = new Thread(() -> {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo("emailt407@gmail.com");
            msg.setSubject("New movie added");
            int idx = movieService.getMovies().size();
            msg.setText(movieService.getMovies().get(idx - 1).toString());
            try {
                emailSender.send(msg);
                System.out.println("email send");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();

    }

}

package pl.inome.moviesaop.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.inome.moviesaop.service.MovieService;

@Service
class EmailServiceImp implements EmailService {

    private JavaMailSender emailSender;
    private MovieService movieService;

    @Autowired
    public EmailServiceImp(JavaMailSender emailSender, MovieService movieService) {
        this.emailSender = emailSender;
        this.movieService = movieService;
    }

    @Override
    public void sendMessage(String to) {
        Thread thread = new Thread(() -> {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(to);
            msg.setSubject("New movie added");
            int idx = movieService.getMovies().size();
            msg.setText(movieService.getMovies().get(idx - 1).toString());
            try {
                emailSender.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}

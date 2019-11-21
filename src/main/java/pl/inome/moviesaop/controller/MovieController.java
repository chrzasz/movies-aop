package pl.inome.moviesaop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.inome.moviesaop.email.EmailSend;
import pl.inome.moviesaop.model.Movie;
import pl.inome.moviesaop.service.MovieService;

@Controller
class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        model.addAttribute("newMovie", new Movie());
        return "index";
    }

    @PostMapping("/addMovie")
    @EmailSend
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/";
    }

}

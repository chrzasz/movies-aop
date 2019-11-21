package pl.inome.moviesaop.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.inome.moviesaop.email.EmailSend;

import java.util.List;

@RestController
@RequestMapping(value = "/api/movies")
class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping
    @EmailSend
    public String addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return "added: " + movie;
    }

}

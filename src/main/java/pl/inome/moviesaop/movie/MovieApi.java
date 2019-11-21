package pl.inome.moviesaop.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inome.moviesaop.email.EmailSend;

@RestController
@RequestMapping(value = "/api/movies")
class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> getMovies() {
        if (movieService.getMovies().iterator().hasNext())
            return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @EmailSend
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return (movieService.addMovie(movie))
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

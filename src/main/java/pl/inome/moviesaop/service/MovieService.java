package pl.inome.moviesaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inome.moviesaop.model.Movie;
import pl.inome.moviesaop.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    public boolean addMovie(Movie movie) {
        if (movie.getTitle() != null
                && movie.getProductionYear() != null
                && movie.getProducer() != null) {
            movieRepository.addMovie(movie);
            return true;
        }
        return false;
    }
}

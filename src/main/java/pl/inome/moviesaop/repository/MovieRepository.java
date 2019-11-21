package pl.inome.moviesaop.repository;

import org.springframework.stereotype.Repository;
import pl.inome.moviesaop.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private List<Movie> movies;

    public MovieRepository() {
        this.movies = new ArrayList<>();
        this.movies.add(new Movie("Seksmisja", 1983, "Poland"));
        this.movies.add(new Movie("Dzień Swira", 2002, "Poland"));
        this.movies.add(new Movie("Joker", 2019, "USA"));
        this.movies.add(new Movie("The Butterfly Effect", 2004, "Canada"));
        this.movies.add(new Movie("Anand", 1971, "India"));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

}

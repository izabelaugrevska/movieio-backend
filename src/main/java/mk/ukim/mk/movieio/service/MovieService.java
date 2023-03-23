package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();
    Optional<Movie> findById(Integer id);
    Movie save(Movie movie);

}

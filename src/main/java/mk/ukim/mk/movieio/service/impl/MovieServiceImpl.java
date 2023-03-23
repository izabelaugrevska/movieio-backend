package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.model.Movie;
import mk.ukim.mk.movieio.repository.MovieRepository;
import mk.ukim.mk.movieio.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

}

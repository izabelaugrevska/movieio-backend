package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.MovieProjectionDto;
import mk.ukim.mk.movieio.model.Movie;
import mk.ukim.mk.movieio.model.MovieProjection;
import mk.ukim.mk.movieio.model.MovieTheater;
import mk.ukim.mk.movieio.repository.MovieProjectionRepository;
import mk.ukim.mk.movieio.repository.MovieRepository;
import mk.ukim.mk.movieio.repository.MovieTheaterRepository;
import mk.ukim.mk.movieio.service.MovieProjectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieProjectionServiceImpl implements MovieProjectionService {

    private final MovieProjectionRepository movieProjectionRepository;
    private final MovieRepository movieRepository;
    private final MovieTheaterRepository movieTheaterRepository;

    public MovieProjectionServiceImpl(MovieProjectionRepository movieProjectionRepository, MovieRepository movieRepository,
                                      MovieTheaterRepository movieTheaterRepository) {
        this.movieProjectionRepository = movieProjectionRepository;
        this.movieRepository = movieRepository;
        this.movieTheaterRepository = movieTheaterRepository;
    }

    @Override
    public List<MovieProjection> findAll() {
        return movieProjectionRepository.findAll();
    }

    @Override
    public MovieProjection save(MovieProjectionDto projectionDto) {
        Movie movie = movieRepository.findById(projectionDto.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));
        MovieTheater theater = movieTheaterRepository.findById(projectionDto.getMovieTheaterId()).orElseThrow(() -> new RuntimeException("Movie theater not found"));

        MovieProjection projection = new MovieProjection();
        projection.setProjectionDate(projectionDto.getProjectionDate());
        projection.setProjectionTime(projectionDto.getProjectionTime());
        projection.setPrice(projectionDto.getPrice());
        projection.setMovie(movie);
        projection.setMovieTheater(theater);

        return movieProjectionRepository.save(projection);
    }

    @Override
    public List<MovieProjection> findAllByMovieId(Integer movieId) {
        return movieProjectionRepository.findAllByMovie_Id(movieId);
    }
}

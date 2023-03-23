package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.MovieProjectionDto;
import mk.ukim.mk.movieio.model.MovieProjection;

import java.util.List;

public interface MovieProjectionService {

    List<MovieProjection> findAll();
    MovieProjection save(MovieProjectionDto projectionDto);
    List<MovieProjection>findAllByMovieId(Integer movieId);

}

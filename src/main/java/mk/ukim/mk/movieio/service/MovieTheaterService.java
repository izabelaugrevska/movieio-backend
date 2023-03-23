package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.MovieTheaterDto;
import mk.ukim.mk.movieio.model.MovieTheater;

import java.util.List;

public interface MovieTheaterService {

    List<MovieTheater> findAll();
    MovieTheater save(MovieTheaterDto movieTheaterDto);

}

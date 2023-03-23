package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.MovieTheaterDto;
import mk.ukim.mk.movieio.model.MovieTheater;
import mk.ukim.mk.movieio.repository.MovieTheaterRepository;
import mk.ukim.mk.movieio.service.MovieTheaterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheaterServiceImpl implements MovieTheaterService {

    private final MovieTheaterRepository movieTheaterRepository;

    public MovieTheaterServiceImpl(MovieTheaterRepository movieTheaterRepository) {
        this.movieTheaterRepository = movieTheaterRepository;
    }

    @Override
    public List<MovieTheater> findAll() {
        return movieTheaterRepository.findAll();
    }

    @Override
    public MovieTheater save(MovieTheaterDto movieTheaterDto) {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.setMovieTheaterName(movieTheaterDto.getMovieTheaterName());
        movieTheater.setCapacity(movieTheaterDto.getCapacity());
        return movieTheaterRepository.save(movieTheater);
    }
}

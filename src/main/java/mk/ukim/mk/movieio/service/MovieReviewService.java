package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.GetMovieReviewDto;
import mk.ukim.mk.movieio.web.dto.MovieReviewDto;
import mk.ukim.mk.movieio.model.MovieReview;

import java.util.List;
import java.util.Optional;

public interface MovieReviewService {

    List<GetMovieReviewDto> findAll();
    Optional<MovieReview> save(MovieReviewDto movieReviewDto);

}

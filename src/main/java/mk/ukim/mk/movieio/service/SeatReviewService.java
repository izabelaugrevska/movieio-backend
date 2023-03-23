package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.SeatReviewDto;
import mk.ukim.mk.movieio.model.SeatReview;

import java.util.List;
import java.util.Optional;

public interface SeatReviewService {
    List<SeatReview> findAll();
    Optional<SeatReview> save(SeatReviewDto seatReviewDto);
}

package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.SeatDto;
import mk.ukim.mk.movieio.model.Seat;

import java.util.List;
import java.util.Optional;


public interface SeatService {

    List<Seat> findAll();
    Optional<Seat> findById(Integer id);
    Seat save(SeatDto seatDto);
    List<Seat> findAllByMovieTheaterId(Integer movieTheaterId);

}

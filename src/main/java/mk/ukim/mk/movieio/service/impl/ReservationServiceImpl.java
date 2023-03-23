package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.ReservationDto;
import mk.ukim.mk.movieio.model.MovieProjection;
import mk.ukim.mk.movieio.model.Reservation;
import mk.ukim.mk.movieio.repository.MovieProjectionRepository;
import mk.ukim.mk.movieio.repository.ReservationRepository;
import mk.ukim.mk.movieio.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final MovieProjectionRepository movieProjectionRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, MovieProjectionRepository movieProjectionRepository) {
        this.reservationRepository = reservationRepository;
        this.movieProjectionRepository = movieProjectionRepository;
    }

    @Override
    public void save(ReservationDto reservationDto) {
        MovieProjection  movieProjection = movieProjectionRepository.findById(reservationDto.getMovieProjectionId())
                .orElseThrow(() -> new RuntimeException("Projection not found"));

        Reservation reservation = new Reservation();
        reservation.setMovieProjection(movieProjection);
        reservation.setDate(reservationDto.getDate());
        reservation.setPrice(reservationDto.getPrice());
        reservation.setSeat(reservationDto.getSeat());
        reservation.setTime(reservationDto.getTime());
        reservation.setStatus(reservationDto.getStatus());
        // TO DO: Set customer, Set employee?
        reservationRepository.save(reservation);

    }
}

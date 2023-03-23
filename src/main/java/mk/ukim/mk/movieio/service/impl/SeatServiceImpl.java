package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.SeatDto;
import mk.ukim.mk.movieio.model.Seat;
import mk.ukim.mk.movieio.repository.SeatRepository;
import mk.ukim.mk.movieio.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> findById(Integer id) {
        return seatRepository.findById(id);
    }

    @Override
    public Seat save(SeatDto seatDto) {
    Seat seat = new Seat();
    seat.setSeatNumber(seatDto.getSeatNumber());
    seat.setMovieTheaterId(seatDto.getMovieTheaterId());
    seat.setSeatPoints(seatDto.getSeatPoints());
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> findAllByMovieTheaterId(Integer movieTheaterId) {
        return seatRepository.findAllByMovieTheaterId(movieTheaterId);
    }
}

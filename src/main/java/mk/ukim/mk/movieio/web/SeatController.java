package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.SeatDto;
import mk.ukim.mk.movieio.model.Seat;
import mk.ukim.mk.movieio.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/getSeats")
    public List<Seat> getSeats(){
        return seatService.findAll();
    }

    @PostMapping("/addSeat")
    public Seat save(@RequestBody SeatDto seatDto){
        return this.seatService.save(seatDto);
    }

    @GetMapping("/getSeatsByMovieTheaterId/{movieTheaterId}")
    public List<Seat> findAllByMovieTheaterId(@PathVariable Integer movieTheaterId){
        return this.seatService.findAllByMovieTheaterId(movieTheaterId);
    }
}

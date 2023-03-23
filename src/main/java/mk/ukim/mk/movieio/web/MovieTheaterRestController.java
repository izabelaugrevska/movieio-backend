package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.MovieTheaterDto;
import mk.ukim.mk.movieio.model.MovieTheater;
import mk.ukim.mk.movieio.service.MovieTheaterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/theaters")
public class MovieTheaterRestController {

    private final MovieTheaterService movieTheaterService;

    public MovieTheaterRestController(MovieTheaterService movieTheaterService) {
        this.movieTheaterService = movieTheaterService;
    }

    @GetMapping("/getTheaters")
    public List<MovieTheater> getMovieTheaters() {
        return movieTheaterService.findAll();
    }

    @PostMapping("/addTheaters")
    public MovieTheater saveTheater(@RequestBody MovieTheaterDto movieTheaterDto) {
        return movieTheaterService.save(movieTheaterDto);
    }
}

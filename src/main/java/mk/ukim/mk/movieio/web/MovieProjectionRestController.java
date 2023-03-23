package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.MovieProjectionDto;
import mk.ukim.mk.movieio.model.MovieProjection;
import mk.ukim.mk.movieio.service.MovieProjectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/projections")
public class MovieProjectionRestController {

    private final MovieProjectionService movieProjectionService;

    public MovieProjectionRestController(MovieProjectionService movieProjectionService) {
        this.movieProjectionService = movieProjectionService;
    }

    @GetMapping("/getProjections")
    public List<MovieProjection> getMovieProjections() {
        return movieProjectionService.findAll();
    }

    @PostMapping("/addProjection")
    public MovieProjection save(@RequestBody MovieProjectionDto movieProjection) {
        return this.movieProjectionService.save(movieProjection);
    }

    @GetMapping("/getProjectionsByMovieId/{movieId}")
    public List<MovieProjection> findAllByMovieId(@PathVariable Integer movieId){
        return this.movieProjectionService.findAllByMovieId(movieId);
    }
}

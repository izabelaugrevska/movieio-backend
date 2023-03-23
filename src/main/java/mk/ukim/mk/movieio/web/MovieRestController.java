package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.model.Movie;
import mk.ukim.mk.movieio.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Integer id)
    {
        return movieService.findById(id);
    }


    @PostMapping("/addMovie")
    public Movie save(@RequestBody Movie movie) {
        return this.movieService.save(movie);
    }

}
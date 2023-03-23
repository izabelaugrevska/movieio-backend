package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.GetMovieReviewDto;
import mk.ukim.mk.movieio.web.dto.MovieReviewDto;
import mk.ukim.mk.movieio.model.MovieReview;
import mk.ukim.mk.movieio.service.MovieReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/reviews")
public class MovieReviewController {

    private final MovieReviewService movieReviewService;

    public MovieReviewController(MovieReviewService movieReviewService) {
        this.movieReviewService = movieReviewService;
    }

    @GetMapping("/getReviews")
    public List<GetMovieReviewDto> getMovieReviews() {

        return movieReviewService.findAll();
    }

    @PostMapping("/addReviews")
    public Optional<MovieReview> save(@RequestBody MovieReviewDto movieReviewDto)
    {
        return movieReviewService.save(movieReviewDto);
    }

}

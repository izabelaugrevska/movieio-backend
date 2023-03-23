package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.SeatReviewDto;
import mk.ukim.mk.movieio.model.SeatReview;
import mk.ukim.mk.movieio.service.SeatReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/seatreviews")
public class SeatReviewController {
    private final SeatReviewService seatReviewService;

    public SeatReviewController(SeatReviewService seatReviewService) {
        this.seatReviewService = seatReviewService;
    }

    @GetMapping("/getReviews")
    public List<SeatReview> getMovieReviews() {

        return seatReviewService.findAll();
    }

    @PostMapping("/addReviews")
    public Optional<SeatReview> save(@RequestBody SeatReviewDto seatReviewDto)
    {
        return seatReviewService.save(seatReviewDto);
    }
}

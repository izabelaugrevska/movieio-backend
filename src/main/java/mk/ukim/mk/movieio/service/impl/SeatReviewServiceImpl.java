package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.SeatReviewDto;
import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.model.Seat;
import mk.ukim.mk.movieio.model.SeatReview;
import mk.ukim.mk.movieio.repository.CustomerRepository;
import mk.ukim.mk.movieio.repository.SeatRepository;
import mk.ukim.mk.movieio.repository.SeatReviewRepository;
import mk.ukim.mk.movieio.service.SeatReviewService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SeatReviewServiceImpl implements SeatReviewService {

    private final SeatReviewRepository seatReviewRepository;
    private final CustomerRepository customerRepository;
    private final SeatRepository seatRepository;

    public SeatReviewServiceImpl(SeatReviewRepository seatReviewRepository, CustomerRepository customerRepository,
                                 SeatRepository seatRepository)
    {
        this.seatReviewRepository = seatReviewRepository;
        this.customerRepository = customerRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public List<SeatReview> findAll() {
        return seatReviewRepository.findAll();
    }

    @Override
    public Optional<SeatReview> save(SeatReviewDto seatReviewDto) {
        SeatReview seatReview = new SeatReview();
        seatReview.setRating(seatReviewDto.getRating());

        Optional<Customer> optionalCustomer = customerRepository.findById(seatReviewDto.getCustomerId());
        Customer customer = optionalCustomer.orElse(null);
        seatReview.setCustomer(customer);
        Optional<Seat> optionalSeat = seatRepository.findById(seatReviewDto.getSeatId());
        Seat seat = optionalSeat.orElse(null);
        seatReview.setSeat(seat);
        return Optional.of(seatReviewRepository.save(seatReview));
    }
}

package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.web.dto.PaymentDto;
import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.model.MovieProjection;
import mk.ukim.mk.movieio.model.Payment;
import mk.ukim.mk.movieio.model.Seat;
import mk.ukim.mk.movieio.repository.CustomerRepository;
import mk.ukim.mk.movieio.repository.MovieProjectionRepository;
import mk.ukim.mk.movieio.repository.PaymentRepository;
import mk.ukim.mk.movieio.repository.SeatRepository;
import mk.ukim.mk.movieio.service.PaymentService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;
    private final MovieProjectionRepository movieProjectionRepository;
    private final SeatRepository seatRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, CustomerRepository customerRepository, MovieProjectionRepository movieProjectionRepository, SeatRepository seatRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
        this.movieProjectionRepository = movieProjectionRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment save(PaymentDto paymentDto) {

        Customer customer = customerRepository.findById(paymentDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        MovieProjection projection = movieProjectionRepository.findById(paymentDto.getMovieProjectionId())
                .orElseThrow(() -> new RuntimeException("Movie projection not found"));
        Seat seat = seatRepository.findById(paymentDto.getSeatId())
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setCustomer(customer);
        payment.setMovieProjection(projection);
        payment.setSeat(seat);
        payment.getSeat().setStatus("booked");
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentRepository.findById(id);
    }
}

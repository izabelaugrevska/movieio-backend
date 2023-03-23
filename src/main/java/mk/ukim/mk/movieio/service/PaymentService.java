package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.web.dto.PaymentDto;
import mk.ukim.mk.movieio.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAll();
    Payment save(PaymentDto paymentDto);
    Optional<Payment> findById(Integer id);
}

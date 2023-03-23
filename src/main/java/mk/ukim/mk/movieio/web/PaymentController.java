package mk.ukim.mk.movieio.web;

import mk.ukim.mk.movieio.web.dto.PaymentDto;
import mk.ukim.mk.movieio.model.Payment;
import mk.ukim.mk.movieio.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/getPayment")
    public List<Payment> getPayment(){
        return paymentService.findAll();
    }

    @GetMapping("/getPayment/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Integer id){
        return paymentService.findById(id);
    }

    @PostMapping("/addPayment")
    public Payment save(@RequestBody PaymentDto payment){
        return this.paymentService.save(payment);
    }
}

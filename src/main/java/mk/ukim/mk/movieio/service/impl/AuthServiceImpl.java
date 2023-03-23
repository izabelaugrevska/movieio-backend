package mk.ukim.mk.movieio.service.impl;

import mk.ukim.mk.movieio.model.Customer;
import mk.ukim.mk.movieio.repository.CustomerRepository;
import mk.ukim.mk.movieio.repository.UserRepository;
import mk.ukim.mk.movieio.service.AuthService;
import mk.ukim.mk.movieio.service.exceptions.InvalidArgumentsException;
import mk.ukim.mk.movieio.service.exceptions.InvalidCustomerCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;

    public AuthServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return customerRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidCustomerCredentialsException::new);
    }
}

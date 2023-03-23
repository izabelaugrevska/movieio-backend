package mk.ukim.mk.movieio.service;

import mk.ukim.mk.movieio.model.Customer;

public interface AuthService {
    Customer login(String username, String password);
}

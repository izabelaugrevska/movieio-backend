package mk.ukim.mk.movieio.repository;

import mk.ukim.mk.movieio.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByUsernameAndPassword(String username, String password);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByUsername(String username);
}

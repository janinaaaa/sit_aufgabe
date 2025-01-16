package sit_aufgabe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}

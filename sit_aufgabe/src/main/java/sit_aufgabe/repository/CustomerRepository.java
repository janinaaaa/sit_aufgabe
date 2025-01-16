package sit_aufgabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Customer;

import java.util.Optional;

/**
 * Repository interface for managing Customer entities.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Retrieves a customer by their email.
     *
     * @param email the email of the customer to retrieve
     * @return an Optional containing the customer if found, or empty if not found
     */
    Optional<Customer> findByEmail(String email);
}
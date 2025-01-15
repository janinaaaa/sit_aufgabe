package sit_aufgabe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sit_aufgabe.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

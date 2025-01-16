package sit_aufgabe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.AuthenticationResponse;
import sit_aufgabe.dto.RegisterCustomerRequest;
import sit_aufgabe.model.Customer;
import sit_aufgabe.repository.CustomerRepository;
import sit_aufgabe.service.customer.CustomerService;

import java.util.List;

/**
 * REST controller for managing customers.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    /**
     * Registers a new customer.
     *
     * @param customer the customer registration request
     * @return a ResponseEntity containing the authentication response
     */
    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerCustomer(@RequestBody RegisterCustomerRequest customer) {
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }

    /**
     * Authenticates a customer.
     *
     * @param customer the authentication request
     * @return a ResponseEntity containing the authentication response
     */
    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest customer) {
        System.out.println(customer);
        System.out.println("login");
        return ResponseEntity.ok(customerService.authenticate(customer));
    }

    /**
     * Retrieves all customers.
     *
     * @return a ResponseEntity containing a list of all customers
     */
    @PreAuthorize("permitAll()")
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
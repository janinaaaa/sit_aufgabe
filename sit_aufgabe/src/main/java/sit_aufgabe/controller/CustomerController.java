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


@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerCustomer(@RequestBody RegisterCustomerRequest customer) {
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest customer) {
        System.out.println(customer);
        System.out.println("login");
        return ResponseEntity.ok(customerService.authenticate(customer));
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }
}

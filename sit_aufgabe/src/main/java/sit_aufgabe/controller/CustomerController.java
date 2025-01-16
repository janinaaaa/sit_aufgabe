package sit_aufgabe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.AuthenticationResponse;
import sit_aufgabe.dto.RegisterCustomerRequest;
import sit_aufgabe.service.customer.CustomerService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerCustomer(@RequestBody RegisterCustomerRequest customer) {
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest customer) {
        return ResponseEntity.ok(customerService.authenticate(customer));
    }
}

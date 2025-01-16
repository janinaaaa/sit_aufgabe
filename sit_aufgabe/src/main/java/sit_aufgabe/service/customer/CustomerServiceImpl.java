package sit_aufgabe.service.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.AuthenticationResponse;
import sit_aufgabe.dto.RegisterCustomerRequest;
import sit_aufgabe.mapper.CustomerMapper;
import sit_aufgabe.model.Customer;
import sit_aufgabe.model.Role;
import sit_aufgabe.repository.CustomerRepository;
import sit_aufgabe.service.JwtService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse registerCustomer(RegisterCustomerRequest customer) {
        Customer newCustomer = customerMapper.toCustomer(customer);
        newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        newCustomer.setRole(Role.CUSTOMER);
        customerRepository.save(newCustomer);
        var token = jwtService.generateToken(newCustomer);
        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest customer) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword()));
        Customer customerEntity = customerRepository.findByEmail(customer.getEmail()).orElseThrow();
        var token = jwtService.generateToken(customerEntity);
        return new AuthenticationResponse(token);
    }
}

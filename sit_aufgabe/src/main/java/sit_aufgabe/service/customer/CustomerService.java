package sit_aufgabe.service.customer;

import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.AuthenticationResponse;
import sit_aufgabe.dto.RegisterCustomerRequest;

public interface CustomerService {
    AuthenticationResponse registerCustomer(RegisterCustomerRequest customer);
    AuthenticationResponse authenticate(AuthenticationRequest customer);
}

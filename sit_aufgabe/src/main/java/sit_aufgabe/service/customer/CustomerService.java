package sit_aufgabe.service.customer;

import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.AuthenticationResponse;
import sit_aufgabe.dto.RegisterCustomerRequest;

/**
 * Service interface for managing customer authentication and registration.
 */
public interface CustomerService {

    /**
     * Registers a new customer.
     *
     * @param customer the customer registration request
     * @return the authentication response containing the JWT token
     */
    AuthenticationResponse registerCustomer(RegisterCustomerRequest customer);

    /**
     * Authenticates a customer.
     *
     * @param customer the authentication request
     * @return the authentication response containing the JWT token
     */
    AuthenticationResponse authenticate(AuthenticationRequest customer);
}
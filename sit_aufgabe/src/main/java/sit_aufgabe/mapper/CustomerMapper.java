package sit_aufgabe.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.RegisterCustomerRequest;
import sit_aufgabe.model.Customer;

/**
 * Mapper class for converting between Customer entities and DTOs.
 */
@Component
@RequiredArgsConstructor
public class CustomerMapper {

    /**
     * Converts a RegisterCustomerRequest DTO to a Customer entity.
     *
     * @param registerCustomerRequest the RegisterCustomerRequest DTO
     * @return the Customer entity
     */
    public Customer toCustomer(RegisterCustomerRequest registerCustomerRequest){
        Customer customer = new Customer();
        customer.setName(registerCustomerRequest.getName());
        customer.setEmail(registerCustomerRequest.getEmail());
        customer.setPassword(registerCustomerRequest.getPassword());
        return customer;
    }

    /**
     * Converts a Customer entity to a RegisterCustomerRequest DTO.
     *
     * @param customer the Customer entity
     * @return the RegisterCustomerRequest DTO
     */
    public RegisterCustomerRequest toRegisterCustomerRequest(Customer customer){
        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest();
        registerCustomerRequest.setName(customer.getName());
        registerCustomerRequest.setEmail(customer.getEmail());
        registerCustomerRequest.setPassword(customer.getPassword());
        return registerCustomerRequest;
    }

    /**
     * Converts an AuthenticationRequest DTO to a Customer entity.
     *
     * @param authenticationRequest the AuthenticationRequest DTO
     * @return the Customer entity
     */
    public Customer toCustomer(AuthenticationRequest authenticationRequest){
        Customer customer = new Customer();
        customer.setEmail(authenticationRequest.getEmail());
        customer.setPassword(authenticationRequest.getPassword());
        return customer;
    }
}
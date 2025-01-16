package sit_aufgabe.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sit_aufgabe.dto.AuthenticationRequest;
import sit_aufgabe.dto.RegisterCustomerRequest;
import sit_aufgabe.model.Customer;

@Component
@RequiredArgsConstructor
public class CustomerMapper {
    public Customer toCustomer(RegisterCustomerRequest registerCustomerRequest){
        Customer customer = new Customer();
        customer.setName(registerCustomerRequest.getName());
        customer.setEmail(registerCustomerRequest.getEmail());
        customer.setPassword(registerCustomerRequest.getPassword());
        return customer;
    }

    public RegisterCustomerRequest toRegisterCustomerRequest(Customer customer){
        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest();
        registerCustomerRequest.setName(customer.getName());
        registerCustomerRequest.setEmail(customer.getEmail());
        registerCustomerRequest.setPassword(customer.getPassword());
        return registerCustomerRequest;
    }

    public Customer toCustomer(AuthenticationRequest authenticationRequest){
        Customer customer = new Customer();
        customer.setEmail(authenticationRequest.getEmail());
        customer.setPassword(authenticationRequest.getPassword());
        return customer;
    }

}

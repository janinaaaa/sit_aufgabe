package sit_aufgabe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import sit_aufgabe.dto.RegisterCustomerRequest;
import sit_aufgabe.model.Customer;
import sit_aufgabe.repository.CustomerRepository;
import sit_aufgabe.service.customer.CustomerService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private CustomerController customerController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }





    @Test
    void testRegisterCustomer() {
        // Arrange
        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest("username", "email", "password");
        Customer mockCustomer = new Customer();
        mockCustomer.setEmail(registerCustomerRequest.getEmail());
        mockCustomer.setName(registerCustomerRequest.getName());
        mockCustomer.setPassword(registerCustomerRequest.getPassword());

        // // Define Behavior for the Mock
        when(customerRepository.findByEmail(registerCustomerRequest.getEmail())).thenReturn(Optional.of(mockCustomer));

        // Act
        customerController.registerCustomer(registerCustomerRequest);

        // Assert
        Customer savedCustomer = customerRepository.findByEmail(registerCustomerRequest.getEmail()).get();
        assertNotNull(savedCustomer);
        assertEquals(registerCustomerRequest.getEmail(), savedCustomer.getEmail());
        assertEquals(registerCustomerRequest.getPassword(), savedCustomer.getPassword());
        assertEquals(registerCustomerRequest.getName(), savedCustomer.getName());
    }

    @Test
    void testLogInCustomer(){
        // Arrange
        RegisterCustomerRequest registerCustomerRequest = new RegisterCustomerRequest("username", "email", "password");
        Customer mockCustomer = new Customer();
        mockCustomer.setEmail(registerCustomerRequest.getEmail());
        mockCustomer.setName(registerCustomerRequest.getName());
        mockCustomer.setPassword(registerCustomerRequest.getPassword());

        // Define Behavior for the Mock
        when(customerRepository.findByEmail(registerCustomerRequest.getEmail())).thenReturn(Optional.of(mockCustomer));

        // Act
        customerController.registerCustomer(registerCustomerRequest);

        // Assert
        Customer savedCustomer = customerRepository.findByEmail(registerCustomerRequest.getEmail()).get();
        assertNotNull(savedCustomer);
        assertEquals(registerCustomerRequest.getEmail(), savedCustomer.getEmail());
        assertEquals(registerCustomerRequest.getPassword(), savedCustomer.getPassword());
        assertEquals(registerCustomerRequest.getName(), savedCustomer.getName());
    }




}
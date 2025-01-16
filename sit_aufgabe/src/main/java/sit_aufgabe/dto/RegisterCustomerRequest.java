package sit_aufgabe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for registering a new customer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerRequest {

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email of the customer.
     */
    private String email;

    /**
     * The password of the customer.
     */
    private String password;
}
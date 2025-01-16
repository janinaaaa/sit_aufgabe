package sit_aufgabe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for authentication requests.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The password of the user.
     */
    private String password;
}
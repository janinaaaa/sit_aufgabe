package sit_aufgabe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for authentication responses.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    /**
     * The JSON Web Token (JWT) for the authenticated user.
     */
    private String jwt;
}
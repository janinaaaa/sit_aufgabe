package sit_aufgabe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Entity class representing a Customer.
 * Implements UserDetails for Spring Security integration.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer implements UserDetails {

    /**
     * The unique identifier for the customer.
     * Generated automatically.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email of the customer.
     * Used as the username for authentication.
     */
    private String email;

    /**
     * The password of the customer.
     */
    private String password;

    /**
     * The role of the customer.
     * Defaults to CUSTOMER.
     */
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;

    /**
     * Returns the authorities granted to the customer.
     *
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    /**
     * Returns the username used to authenticate the customer.
     *
     * @return the email of the customer
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the customer's account has expired.
     *
     * @return true if the account is non-expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the customer is locked or unlocked.
     *
     * @return true if the account is non-locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the customer's credentials (password) has expired.
     *
     * @return true if the credentials are non-expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the customer is enabled or disabled.
     *
     * @return true if the customer is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
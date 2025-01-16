package sit_aufgabe.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sit_aufgabe.repository.CustomerRepository;

/**
 * Configuration class for application security settings.
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final CustomerRepository customerRepository;

    /**
     * Bean definition for UserDetailsService.
     * This service is used to load user-specific data.
     *
     * @return UserDetailsService implementation that retrieves user details from the customer repository.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));
    }

    /**
     * Bean definition for AuthenticationProvider.
     * This provider is used to perform authentication with a username and password.
     *
     * @param userDetailsService the UserDetailsService to use for retrieving user details.
     * @return an AuthenticationProvider implementation.
     */
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Bean definition for PasswordEncoder.
     * This encoder is used to encode passwords.
     *
     * @return a PasswordEncoder implementation that uses BCrypt hashing.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean definition for AuthenticationManager.
     * This manager is used to handle authentication requests.
     *
     * @param config the AuthenticationConfiguration to use for configuring the authentication manager.
     * @return an AuthenticationManager implementation.
     * @throws Exception if an error occurs while configuring the authentication manager.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

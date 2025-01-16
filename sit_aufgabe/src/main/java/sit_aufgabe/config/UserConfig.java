package sit_aufgabe.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import sit_aufgabe.model.Customer;
import sit_aufgabe.repository.CustomerRepository;


@AllArgsConstructor
@Order(1)
@Configuration
public class UserConfig implements CommandLineRunner {

    private CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Customer admin = new Customer();
        admin.setName("Admin");
        admin.setEmail("admin@mail.schwarz");
        admin.setPassword(passwordEncoder.encode("123456"));

        customerRepository.save(admin);
    }
}
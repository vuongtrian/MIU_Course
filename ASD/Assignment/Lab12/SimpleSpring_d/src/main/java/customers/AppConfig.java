package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        return customerService;
    }

    @Bean
    public CustomerDAO customerDAO() {
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO;
    }

    @Bean
    public EmailSender emailSender() {
        EmailSender emailSender = new EmailSender();
        return emailSender;
    }

    @Bean
    public ILogger logger() {
        return new Logger();
    }
}

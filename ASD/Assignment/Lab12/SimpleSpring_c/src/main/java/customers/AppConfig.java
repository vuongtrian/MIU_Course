package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public CustomerDAO customerDAO() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setLogger(logger());
        return customerDAO;
    }

    @Bean
    public EmailSender emailSender() {
        EmailSender emailSender = new EmailSender();
        emailSender.setLogger(logger());
        return emailSender;
    }

    @Bean
    public ILogger logger() {
        return new Logger();
    }
}

package customers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomerRatingService {
    @Async
    @EventListener
    public void receivedNewAccount(NewAccountEvent event) {
        System.out.println("Customer rating service received: " + event.getMessage());
    }
}

package miu.edu.CarRentalClient;

import miu.edu.CarRentalClient.domain.HistoryDTOList;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HistoryGateway {
    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8081/history";

    public HistoryDTOList getCustomerHistory (long customerNumber) {
        HistoryDTOList list = restTemplate.getForObject(serverUrl+"/customers/{customerNumber}",
                HistoryDTOList.class, customerNumber);
        return list;
    }

    public HistoryDTOList getCarHistory (String licensePlate) {
        HistoryDTOList list = restTemplate.getForObject(serverUrl+"/cars/{licensePlate}",
                HistoryDTOList.class, licensePlate);
        return list;
    }
}

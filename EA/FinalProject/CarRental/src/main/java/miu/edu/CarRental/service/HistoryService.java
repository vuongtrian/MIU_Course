package miu.edu.CarRental.service;

import miu.edu.CarRental.domain.History;
import miu.edu.CarRental.repository.IHistoryRepository;
import miu.edu.CarRental.service.dto.HistoryAdapter;
import miu.edu.CarRental.service.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService implements IHistoryService{

    @Autowired
    private IHistoryRepository historyRepository;

    @Override
    public void addHistory(HistoryDTO historyDTO) {
        historyRepository.save(HistoryAdapter.getHistoryFromHistoryDtoWithoutId(historyDTO));
    }

    @Override
    public List<HistoryDTO> getAllHistoryByCustomer(long customerId) {
        List<History> result = historyRepository.findByCustomerNumber(customerId);
        return HistoryAdapter.getHistoryDtoList(result);
    }

    @Override
    public List<HistoryDTO> getAllHistoryByCar(String licensePlate) {
        List<History> result = historyRepository.findByLicensePlate(licensePlate);
        return HistoryAdapter.getHistoryDtoList(result);
    }
}

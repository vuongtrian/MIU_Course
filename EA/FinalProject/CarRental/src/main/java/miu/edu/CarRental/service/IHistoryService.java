package miu.edu.CarRental.service;

import miu.edu.CarRental.service.dto.HistoryDTO;

import java.util.List;

public interface IHistoryService {
    public void addHistory (HistoryDTO historyDTO);
    public List<HistoryDTO> getAllHistoryByCustomer (long customerId);
    public List<HistoryDTO> getAllHistoryByCar (String licensePlate);
}

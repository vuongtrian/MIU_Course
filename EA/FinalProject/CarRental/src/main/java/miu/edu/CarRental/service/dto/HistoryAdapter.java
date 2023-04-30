package miu.edu.CarRental.service.dto;

import miu.edu.CarRental.domain.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter {
    public static History getHistoryFromHistoryDto (HistoryDTO historyDTO) {
        History history = new History();
        history.setId(historyDTO.getId());
        history.setCustomerNumber(historyDTO.getCustomerNumber());
        history.setLicensePlate(historyDTO.getLicensePlate());
        history.setBrand(historyDTO.getBrand());
        history.setType(historyDTO.getType());
        history.setFromDate(historyDTO.getFromDate());
        history.setToDate(historyDTO.getToDate());
        history.setState(historyDTO.getState());
        return history;
    }

    public static History getHistoryFromHistoryDtoWithoutId (HistoryDTO historyDTO) {
        History history = new History();
        history.setCustomerNumber(historyDTO.getCustomerNumber());
        history.setLicensePlate(historyDTO.getLicensePlate());
        history.setBrand(historyDTO.getBrand());
        history.setType(historyDTO.getType());
        history.setFromDate(historyDTO.getFromDate());
        history.setToDate(historyDTO.getToDate());
        history.setState(historyDTO.getState());
        return history;
    }

    public static HistoryDTO getHistoryDtoFromHistory (History history) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(history.getId());
        historyDTO.setCustomerNumber(history.getCustomerNumber());
        historyDTO.setLicensePlate(history.getLicensePlate());
        historyDTO.setBrand(history.getBrand());
        historyDTO.setType(history.getType());
        historyDTO.setFromDate(history.getFromDate());
        historyDTO.setToDate(history.getToDate());
        historyDTO.setState(history.getState());
        return historyDTO;
    }

    public static List<HistoryDTO> getHistoryDtoList (List<History> historyList) {
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for (History history : historyList) {
            historyDTOList.add(getHistoryDtoFromHistory(history));
        }
        return historyDTOList;
    }

}

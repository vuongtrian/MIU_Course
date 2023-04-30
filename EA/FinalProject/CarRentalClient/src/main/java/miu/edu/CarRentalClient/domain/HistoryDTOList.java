package miu.edu.CarRentalClient.domain;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryDTOList {
    Collection<HistoryDTO> historyDTOS = new ArrayList<>();

    public HistoryDTOList() {
    }

    public HistoryDTOList(Collection<HistoryDTO> historyDTOS) {
        this.historyDTOS = historyDTOS;
    }

    public Collection<HistoryDTO> getHistoryDTOS() {
        return historyDTOS;
    }

    public void setHistoryDTOS(Collection<HistoryDTO> historyDTOS) {
        this.historyDTOS = historyDTOS;
    }

    @Override
    public String toString() {
        return "HistoryDTOList{" +
                "historyDTOS=" + historyDTOS +
                '}';
    }
}

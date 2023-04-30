package miu.edu.CarRental.domain;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryList {
    Collection<History> histories = new ArrayList<>();

    public HistoryList() {
    }

    public HistoryList(Collection<History> histories) {
        this.histories = histories;
    }

    public Collection<History> getHistories() {
        return histories;
    }

    public void setHistories(Collection<History> histories) {
        this.histories = histories;
    }
}

package miu.edu;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private Collection<Observer> observerList = new ArrayList<>();

    public void addObserver (Observer observer) {
        observerList.add(observer);
    }

    public void notify(int speed) {
        for (Observer observer : observerList) {
            observer.update(speed);
        }
    }
}

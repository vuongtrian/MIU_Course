package miu.edu;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private Collection<Observer> observers = new ArrayList<>();

    public void addObserver (Observer observer) {
        observers.add(observer);
    }

    public void doNotify() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

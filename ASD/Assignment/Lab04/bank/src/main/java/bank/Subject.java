package bank;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private Collection<Observer> observerList = new ArrayList<>();

    public void addObserver (Observer observer) {
        observerList.add(observer);
    }

    public void donotify(Account account){
        for (Observer observer: observerList){
            observer.update(account);
        }
    }
}

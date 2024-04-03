package com.FinalProject;

import org.springframework.stereotype.Service;

public interface ITransactionService {
    public void setTransactionDAO(ITransactionDAO transactionDAO);
    public void addTransaction(int id, String name, double amount, Category category);

    public Transaction getTransaction(int id);

    public void removeTransaction(int id);
}

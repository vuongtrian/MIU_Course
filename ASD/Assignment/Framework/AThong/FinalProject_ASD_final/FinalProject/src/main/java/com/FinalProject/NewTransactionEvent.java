package com.FinalProject;

import com.FinalProject.Transaction;

public class NewTransactionEvent {
    private Transaction transaction;

    public NewTransactionEvent(Transaction transaction) {
        super();
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void getTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
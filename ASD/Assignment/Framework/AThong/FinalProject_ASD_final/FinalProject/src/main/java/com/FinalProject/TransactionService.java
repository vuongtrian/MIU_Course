package com.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.custom.aop.Value;

@Service
public class TransactionService implements ITransactionService{
    ITransactionDAO transactionDAO;
    ICategoryDAO categoryDAO;
    
    @Value("smtpserver")
    private String smtpServer;
    
    @Autowired
    private IApplicationEventPublisher publisher;

    @Autowired
    public void setTransactionDAO(ITransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Autowired
    public TransactionService(ICategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }
    
    public void addTransaction(int id, String name, double amount, Category category){
        Transaction transaction = new Transaction(id, name, amount, category);
        categoryDAO.save(category);
        transactionDAO.save(transaction);
        publisher.publishEvent(new NewTransactionEvent(transaction));
    }

    public Transaction getTransaction(int id){
        return transactionDAO.find(id);
    }

    public void removeTransaction(int id){
        transactionDAO.remove(id);
    }
}

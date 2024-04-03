package com.FinalProject;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

public interface ITransactionDAO {
    public void save(Transaction transaction);

    public Transaction find(int id);

    public void remove(int id);
}

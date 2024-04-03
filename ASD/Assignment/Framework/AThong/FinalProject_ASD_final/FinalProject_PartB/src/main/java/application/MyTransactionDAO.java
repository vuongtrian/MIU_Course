package application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.FinalProject.Transaction;

@Repository
public class MyTransactionDAO implements IMyTransactionDAO {
	 private Map<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
	@Override
	public void save(Transaction transaction) {
		System.out.println("New Transaction: " + transaction.toString());
		transactions.put(transaction.getId(), transaction);
	}
}

package application;

import com.FinalProject.*;
import com.custom.aop.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTransactionService implements IMyTransactionService {
    IMyTransactionDAO myTransactionDAO;
    IMyCategoryDAO myCategoryDAO;

    @Value("smtpserver")
    private String smtpServer;


    @Autowired
    public void setMyTransactionDAO(IMyTransactionDAO myTransactionDAO) {
        this.myTransactionDAO = myTransactionDAO;
    }

    @Autowired
    public MyTransactionService(IMyCategoryDAO myCategoryDAO){
        this.myCategoryDAO = myCategoryDAO;
    }
    
    public void addTransaction(){
        Transaction trans = new Transaction(0, "deposit", 199, new Category(0, "cat1"));
        myTransactionDAO.save(trans);
    }
}

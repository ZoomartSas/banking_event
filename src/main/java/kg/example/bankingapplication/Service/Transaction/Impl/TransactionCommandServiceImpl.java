package kg.example.bankingapplication.Service.Transaction.Impl;

import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Service.Transaction.TransactionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {


    @Override
    public void creat(Transaction object) {

    }
}


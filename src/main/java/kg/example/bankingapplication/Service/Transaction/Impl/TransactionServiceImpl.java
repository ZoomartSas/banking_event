package kg.example.bankingapplication.Service.Transaction.Impl;
import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Service.Transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Override
    public void creat(Transaction object) {

    }

    @Override
    public Transaction getById(UUID id) {
        return null;
    }
}

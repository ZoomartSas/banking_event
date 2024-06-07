package kg.example.bankingapplication.Service.Transaction.Impl;

import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Service.Transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    @Override
    public Transaction getById(UUID id) {
        return null;
    }
}

package kg.example.bankingapplication.Service.Transaction.Impl;

import kg.example.bankingapplication.Domein.Exceptions.ResourceNotFoundException;
import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Repository.TransactionRepository;
import kg.example.bankingapplication.Service.Transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {
    private final TransactionRepository repository;
    @Override
    public Transaction getById(UUID id) {
        return repository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

package kg.example.bankingapplication.Service.Account.Impl;

import kg.example.bankingapplication.Domein.Exceptions.ResourceNotFoundException;
import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Repository.AccountRepository;
import kg.example.bankingapplication.Service.Account.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {
    private final AccountRepository accountRepository;
    @Override
    public Account getById(UUID id) {
        return accountRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}

package kg.example.bankingapplication.Service.Account.Impl;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Service.Account.AccountQueryService;
import kg.example.bankingapplication.Service.Account.AccountService;
import lombok.RequiredArgsConstructor;
import org.hibernate.collection.spi.AbstractMapSemantics;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountQueryService accountQueryService;
    private AbstractMapSemantics abstractMapSemantics;
    @Override
    public void creat(Account object) {

    }

    @Override
    public Account getById(UUID id) {
        return accountQueryService.getById(id);
    }
}

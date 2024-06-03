package kg.example.bankingapplication.Service.Account;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Service.CommandService;
import kg.example.bankingapplication.Service.QueryService;

import java.util.UUID;

public interface AccountService
        extends QueryService<Account>,CommandService<Account> {
}

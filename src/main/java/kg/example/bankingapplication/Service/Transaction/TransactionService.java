package kg.example.bankingapplication.Service.Transaction;

import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Service.CommandService;
import kg.example.bankingapplication.Service.QueryService;

public interface TransactionService
        extends CommandService<Transaction>, QueryService<Transaction> {
}

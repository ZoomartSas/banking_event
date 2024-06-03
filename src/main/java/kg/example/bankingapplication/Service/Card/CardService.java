package kg.example.bankingapplication.Service.Card;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.CommandService;
import kg.example.bankingapplication.Service.QueryService;

public interface CardService
        extends QueryService<Card>, CommandService<Card> {
}

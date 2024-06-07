package kg.example.bankingapplication.Service.Card;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.CommandService;
import kg.example.bankingapplication.Service.QueryService;

import java.time.LocalDate;
import java.util.UUID;

public interface CardService
        extends QueryService<Card>, CommandService<Card> {
    void createByClientId (UUID clientId);
    boolean existByNumberAndDate(Long number, LocalDate date);


}

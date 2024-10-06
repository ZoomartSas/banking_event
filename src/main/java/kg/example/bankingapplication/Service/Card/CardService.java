package kg.example.bankingapplication.Service.Card;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.CommandService;
import kg.example.bankingapplication.Service.QueryService;

import java.time.LocalDate;
import java.util.UUID;

public interface CardService
        extends QueryService<Card>, CommandService<Card> {
    void createByClientId (UUID clientId);
    boolean existByNumberAndDate(String number, LocalDate date);
    Card getByNumberAndDateAndCvv(String number, LocalDate date, short cvv);


}

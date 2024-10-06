package kg.example.bankingapplication.Service.Card;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.QueryService;

import java.time.LocalDate;

public interface CardQueryService
        extends QueryService<Card> {
    boolean existByNumberAndDate(String number, LocalDate date);
    Card getByNumberAndDateAndCvv(String number, LocalDate date, short cvv);
}

package kg.example.bankingapplication.Service.Card;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.QueryService;

import java.time.LocalDate;

public interface CardQueryService
        extends QueryService<Card> {
    boolean existByNumberAndDate(Long number, LocalDate date);
}

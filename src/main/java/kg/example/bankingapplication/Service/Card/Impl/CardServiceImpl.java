package kg.example.bankingapplication.Service.Card.Impl;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Card.CardCommandService;
import kg.example.bankingapplication.Service.Card.CardQueryService;
import kg.example.bankingapplication.Service.Card.CardService;
import kg.example.bankingapplication.Service.Client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;
    public void creat(Card object) {

    }

    @Override
    public Card getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void createByClientId(UUID clientId) {
        Client client = clientService.getById(clientId);
        Card card  = new Card(client.getAccount());
        commandService.creat(card);

    }

    @Override
    public boolean existByNumberAndDate(Long number, LocalDate date) {

        return queryService.existByNumberAndDate(number,date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(Long number, LocalDate date, short cvv) {
        return queryService.getByNumberAndDateAndCvv(number,date,cvv);
    }
}

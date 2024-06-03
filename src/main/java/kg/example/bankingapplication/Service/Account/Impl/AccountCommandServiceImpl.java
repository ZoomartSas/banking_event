package kg.example.bankingapplication.Service.Account.Impl;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Events.AccountCreateEvent;
import kg.example.bankingapplication.Repository.AccountRepository;
import kg.example.bankingapplication.Service.Account.AccountCommandService;
import kg.example.bankingapplication.Service.Events.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {
    private EventService eventService;
    @Override
    public void creat(Account object) {
        AccountCreateEvent accountCreateEvent = new AccountCreateEvent(object);
        eventService.create(accountCreateEvent);
    }
}

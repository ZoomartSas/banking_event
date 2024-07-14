package kg.example.bankingapplication.Service.Client.Impl;


import jakarta.transaction.Transactional;
import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Events.ClientCreateEvent;
import kg.example.bankingapplication.Repository.EventRepository;
import kg.example.bankingapplication.Service.Client.ClientCommandService;
import kg.example.bankingapplication.Service.Events.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {
    private final EventService eventService;
    @Override
    public void creat(Card object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);

    }
}

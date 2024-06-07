package kg.example.bankingapplication.Service.Events.Impl;

import kg.example.bankingapplication.Events.AbstractEvent;
import kg.example.bankingapplication.Repository.EventRepository;
import kg.example.bankingapplication.Service.Events.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;


    @Override
    public void create(AbstractEvent event) {
        eventRepository.save(event);
    }
}

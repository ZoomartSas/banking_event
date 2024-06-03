package kg.example.bankingapplication.Service.Events;

import kg.example.bankingapplication.Events.AbstractEvent;

public interface EventService  {
    void create(AbstractEvent event);

}

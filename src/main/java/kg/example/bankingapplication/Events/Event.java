package kg.example.bankingapplication.Events;

import kg.example.bankingapplication.Domein.Aggregate.Aggregate;

public interface Event {
    void apply(Aggregate aggregate);
}

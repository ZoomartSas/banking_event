package kg.example.bankingapplication.Repository;

import kg.example.bankingapplication.Events.AbstractEvent;
import kg.example.bankingapplication.Events.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<AbstractEvent,Long> {
}
package kg.example.bankingapplication.Repository;

import kg.example.bankingapplication.Events.AbstractEvent;
import kg.example.bankingapplication.Events.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<AbstractEvent,Long> {
}
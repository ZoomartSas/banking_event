package kg.example.bankingapplication.Events;

import jakarta.persistence.Entity;
import kg.example.bankingapplication.Domein.Aggregate.Aggregate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientCreateEvent extends AbstractEvent{
    public ClientCreateEvent(Object payload) {

        super(null,EventType.CLIENT_CREATE,payload);
    }

    @Override
    public void apply(Aggregate aggregate) {
        
    }
}

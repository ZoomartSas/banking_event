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
public class CardCreateEvent extends AbstractEvent{
    public CardCreateEvent(Object payload) {
        super(null,EventType.CARD_CREATE,payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}

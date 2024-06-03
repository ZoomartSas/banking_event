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
public class AccountCreateEvent extends AbstractEvent{
    public AccountCreateEvent(Object payload) {
        super(null,EventType
                .ACCOUNT_CREATE,payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}

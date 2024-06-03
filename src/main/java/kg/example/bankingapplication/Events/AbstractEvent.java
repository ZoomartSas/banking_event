package kg.example.bankingapplication.Events;

import jakarta.persistence.*;
import kg.example.bankingapplication.Domein.Model.ObjectConvertor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Table (name = "events")
@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public abstract class AbstractEvent implements Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    UUID aggregateId;

    @Enumerated(EnumType.STRING)
    EventType eventType;

    @CreationTimestamp //фиксация времени сохранения
    LocalDateTime timestamp;
    @JdbcTypeCode(SqlTypes.JSON)
            @Convert(converter = ObjectConvertor.class)
    Object payload;

    public AbstractEvent(UUID aggregateId, EventType eventType, Object payload) {
        this.aggregateId = aggregateId;
        this.eventType = eventType;
        this.payload = payload;
    }
}

package kg.example.bankingapplication.Domein.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table(name = "cards")
@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    UUID id;
    Long number;
    LocalDate date;
    short cvv;
    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn (name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    List<Transaction> transactions;
    @ManyToOne
    Account account;

    public Card(Account account) {
        this.account = account;
    }
}

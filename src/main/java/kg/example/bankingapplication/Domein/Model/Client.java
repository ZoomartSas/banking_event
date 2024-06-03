package kg.example.bankingapplication.Domein.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Table(name = "accounts")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    UUID id;
    String name;
    String surname;
    String userName;
    String secretWord;
    @OneToMany
            @JoinTable(
                    joinColumns = @JoinColumn(name = "client_id"),
                    inverseJoinColumns = @JoinColumn(name = "card_id")
            )
    List<Card> cards;
    @OneToOne
    Account account;
}

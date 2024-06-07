package kg.example.bankingapplication.Web.DTO;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Domein.Model.Transaction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardDto {
    @NotNull(
            message = "ID shouldn't be null",
            groups = OnUpdate.class)

    @Null(message = "ID it should be null",
            groups = OnCreate.class
    )
    UUID id;
    @NotNull(
            message = "Card shouldn't be null",
            groups = OnCreate.class
    )
            @Null(
                    message = "Card it should be null"
            )
    Long number;
    @NotNull(
            message = "Date shouldn't be null",
            groups = OnCreate.class
    )
    @Null(
            message = "Date it should be null"
    )
    LocalDate date;
    @NotNull(
            message = "Card cvv shouldn't be null",
            groups = OnCreate.class
    )
    @Null(
            message = "Card cvv it should be null"
    )
    short cvv;

}

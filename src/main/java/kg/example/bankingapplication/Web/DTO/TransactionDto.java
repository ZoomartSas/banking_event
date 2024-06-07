package kg.example.bankingapplication.Web.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import kg.example.bankingapplication.Domein.Model.Card;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE )
public class TransactionDto {
    @NotNull(
            message = "ID shouldn't be null",
            groups = OnUpdate.class)

    @Null(message = "ID it should be null",
            groups = OnCreate.class
    )
    UUID id;
    @NotNull(groups = OnCreate.class)
    @Valid
    CardDto from;
    @Valid
    @NotNull (groups = OnCreate.class)
    CardDto to;
    @NotNull(groups = OnCreate.class)
    @Positive
    BigDecimal amount;
}

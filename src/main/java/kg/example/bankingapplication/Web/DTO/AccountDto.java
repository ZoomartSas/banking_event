package kg.example.bankingapplication.Web.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {

    @NotNull(
            message = "ID shouldn't be null",
    groups = OnUpdate.class)

    @Null(message = "ID it should be null",
                    groups = OnCreate.class
    )
    UUID id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long number;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    BigDecimal balance;
}

package kg.example.bankingapplication.Web.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
@FieldDefaults (level = AccessLevel.PRIVATE)
public class ClientDto {
    @NotNull(
            message = "ID shouldn't be null",
            groups = OnUpdate.class)

    @Null(message = "ID it should be null",
            groups = OnCreate.class
    )
    UUID id;
    @Length(
            min = 2,
            max = 100
    )
    String name;
    @Length(
            min = 2,
            max = 100
    )
    String surname;
    @Email(
            message = "User Email"
    )
    @Length(
            min = 2,
            max = 100
    )
    String username;
    @NotNull(
            message = "Password it isn't null"
    )
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    String password;
}

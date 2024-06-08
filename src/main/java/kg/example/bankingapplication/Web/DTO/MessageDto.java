package kg.example.bankingapplication.Web.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDto{
    String message;
    Map<String,String> errors;

    public MessageDto(String message) {
        this.message = message;
        this.errors = new HashMap<>();
    }
}

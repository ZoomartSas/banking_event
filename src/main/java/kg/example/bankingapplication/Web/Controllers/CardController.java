package kg.example.bankingapplication.Web.Controllers;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.Card.CardService;
import kg.example.bankingapplication.Web.DTO.CardDto;
import kg.example.bankingapplication.Web.DTO.TransactionDto;
import kg.example.bankingapplication.Web.Mappers.CardMapper;
import kg.example.bankingapplication.Web.Mappers.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public  void create(){
        UUID  id = UUID.randomUUID();
        cardService.createByClientId(id);
    }
    @GetMapping("/{id}")
    private CardDto getById(
            @PathVariable final UUID id
    )
    {
        Card card =cardService.getById(id);
        return cardMapper.toDto(card);
    }
    @GetMapping ("/{id}/transaction")
    public List<TransactionDto> getTransactionById(
            @PathVariable final UUID id
    ){
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }
}

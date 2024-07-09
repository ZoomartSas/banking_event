package kg.example.bankingapplication.Web.Controllers;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Service.Card.CardService;
import kg.example.bankingapplication.Web.DTO.CardDto;
import kg.example.bankingapplication.Web.DTO.TransactionDto;
import kg.example.bankingapplication.Web.Mappers.CardMapper;
import kg.example.bankingapplication.Web.Mappers.TransactionMapper;
import kg.example.bankingapplication.Web.Security.JWT.SecurityUser;
import kg.example.bankingapplication.Web.Security.Service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final SecurityService securityService;

    @PostMapping
    public  void create(){
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }
    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    private CardDto getById(
            @PathVariable final UUID id
    )
    {
        Card card =cardService.getById(id);
        return cardMapper.toDto(card);
    }
    @GetMapping ("/{id}/transaction")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactionById(
            @PathVariable final UUID id
    ){
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }
}

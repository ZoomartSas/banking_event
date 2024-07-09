package kg.example.bankingapplication.Web.Controllers;

import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Service.Card.CardService;
import kg.example.bankingapplication.Service.Transaction.TransactionService;
import kg.example.bankingapplication.Web.DTO.OnCreate;
import kg.example.bankingapplication.Web.DTO.TransactionDto;
import kg.example.bankingapplication.Web.Mappers.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tran")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping("/create")
    @PreAuthorize("@ssi.canAccessTransaction(#dto.from)")
    public  void create(@RequestBody @Validated (OnCreate.class) final TransactionDto dto){
        if (!cardService.existByNumberAndDate(
                dto.getTo().getNumber(),
                dto.getTo().getDate()
        )){
            throw new IllegalStateException("Card not");
        }
        Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.creat(transaction);
    }
    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getById (@PathVariable final UUID id){
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }


}

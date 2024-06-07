package kg.example.bankingapplication.Web.Controllers;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Client.ClientService;
import kg.example.bankingapplication.Web.DTO.AccountDto;
import kg.example.bankingapplication.Web.DTO.CardDto;
import kg.example.bankingapplication.Web.DTO.ClientDto;
import kg.example.bankingapplication.Web.Mappers.AccountMapper;
import kg.example.bankingapplication.Web.Mappers.CardMapper;
import kg.example.bankingapplication.Web.Mappers.ClientMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;
    @GetMapping("/{id}")
    public ClientDto getById(
            @PathVariable final UUID id
            ){
        Client client =clientService.getById(id);
        return clientMapper.toDto(client);
    }
    @GetMapping("{id}/cards")
    public List<CardDto> getCardById(@PathVariable final UUID id){
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }
    @GetMapping("{id}/account")
    public AccountDto getAccountById(
            @PathVariable final UUID id
    ){
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }


}

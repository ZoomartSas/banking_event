package kg.example.bankingapplication.Service.Authorization;

import kg.example.bankingapplication.Domein.Exceptions.ResourceAlreadyExistsException;
import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Card.CardService;
import kg.example.bankingapplication.Service.Client.ClientService;
import kg.example.bankingapplication.Web.DTO.LoginRequestDto;
import kg.example.bankingapplication.Web.DTO.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final ClientService clientService;
    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        return null;
    }

    @Override
    public void register(Client client) {
        if (clientService.existsByUsername(client.getUsername())){
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(client.getPassword());
        clientService.creat(client);

    }
}

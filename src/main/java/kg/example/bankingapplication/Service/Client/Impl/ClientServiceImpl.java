package kg.example.bankingapplication.Service.Client.Impl;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Client.ClientCommandService;
import kg.example.bankingapplication.Service.Client.ClientQueryService;
import kg.example.bankingapplication.Service.Client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
 public class ClientServiceImpl implements ClientService {

    private final ClientQueryService queryService;
    private final ClientCommandService commandService;
    @Override
    public void creat(Client object) {

    }

    @Override
    public Client getById(UUID id) {
        return null;
    }
    @Override
    public boolean existsByUsername(String username) {

        return queryService.existsByUsername(username);
    }
}

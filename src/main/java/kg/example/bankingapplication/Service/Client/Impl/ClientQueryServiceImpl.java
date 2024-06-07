package kg.example.bankingapplication.Service.Client.Impl;


import kg.example.bankingapplication.Domein.Exceptions.ResourceNotFoundException;
import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Repository.ClientRepository;
import kg.example.bankingapplication.Service.Client.ClientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {
private final ClientRepository clientRepository;
    @Override
    public Client getById(UUID id) {
        return clientRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(String username) {
        return clientRepository
                .existsByUsername(username);
    }
}

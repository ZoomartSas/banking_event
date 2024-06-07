package kg.example.bankingapplication.Service.Client;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.CommandService;
import kg.example.bankingapplication.Service.QueryService;

public interface ClientService extends QueryService<Client>,CommandService<Client>{
    boolean existsByUsername(String username);
}
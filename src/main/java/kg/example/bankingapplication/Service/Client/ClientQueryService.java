package kg.example.bankingapplication.Service.Client;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.QueryService;

public interface ClientQueryService
        extends QueryService<Client> {

    boolean existsByUsername(String username);

}

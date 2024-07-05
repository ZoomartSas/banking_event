package kg.example.bankingapplication.Web.Security;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Client.ClientService;
import kg.example.bankingapplication.Web.Security.JWT.SecurityUser;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityUserService implements UserDetailsService {
    private  final ClientService clientService;

    public SecurityUserService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username)  {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }

}

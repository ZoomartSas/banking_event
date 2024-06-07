package kg.example.bankingapplication.Service.Authorization;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Web.DTO.LoginRequestDto;
import kg.example.bankingapplication.Web.DTO.LoginResponseDto;
import org.springframework.stereotype.Service;

public interface AuthorizationService {
    LoginResponseDto login(LoginRequestDto requestDto);
    void register (Client client);
}

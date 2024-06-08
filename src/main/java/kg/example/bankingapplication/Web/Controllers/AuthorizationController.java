package kg.example.bankingapplication.Web.Controllers;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Authorization.AuthorizationService;
import kg.example.bankingapplication.Web.DTO.ClientDto;
import kg.example.bankingapplication.Web.DTO.LoginRequestDto;
import kg.example.bankingapplication.Web.DTO.LoginResponseDto;
import kg.example.bankingapplication.Web.DTO.OnCreate;
import kg.example.bankingapplication.Web.Mappers.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    private final ClientMapper clientMapper;


    @PostMapping("/req")
    public void register(
            @RequestBody @Validated(OnCreate.class) final ClientDto dto ){
        Client client = clientMapper.fromDto(dto);
        authorizationService.register(client);
    }
    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody @Validated final LoginRequestDto dto){
        return authorizationService.login(dto);
    }

}

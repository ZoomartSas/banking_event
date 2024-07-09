package kg.example.bankingapplication.Service.Authorization;

import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import kg.example.bankingapplication.Domein.Exceptions.ResourceAlreadyExistsException;
import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Service.Client.ClientService;
import kg.example.bankingapplication.Web.DTO.LoginRequestDto;
import kg.example.bankingapplication.Web.DTO.LoginResponseDto;
import kg.example.bankingapplication.Web.Security.JWT.JwtProperties;
import kg.example.bankingapplication.Web.Security.JWT.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final ClientService clientService;
    private final TokenService tokenService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getUserName(),
                        requestDto.getPassword()
                )
        );
        LoginResponseDto response = new LoginResponseDto();
        response.setAccess(tokenService
                        .create(TokenParameters
                                .builder(
                                        requestDto.getUserName(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                )
                                .build()
                        )
        );
        response.setRefresh(tokenService
                .create(TokenParameters
                        .builder(
                                response.getRefresh(),
                                TokenType.REFRESH.name(),
                                jwtProperties.getRefresh()
                        )
                        .build()
                )
        );
        return  response;
    }

    @Override
    public void register(Client client) {
        if (clientService
                .existsByUsername(client.getUsername())){
            throw new ResourceAlreadyExistsException();
        }

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.creat(client);

    }
}

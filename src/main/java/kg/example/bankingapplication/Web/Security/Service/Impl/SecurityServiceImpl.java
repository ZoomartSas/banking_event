package kg.example.bankingapplication.Web.Security.Service.Impl;

import kg.example.bankingapplication.Domein.Exceptions.ResourceNotFoundException;
import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Service.Card.CardService;
import kg.example.bankingapplication.Service.Client.ClientService;
import kg.example.bankingapplication.Service.Transaction.TransactionService;
import kg.example.bankingapplication.Web.Security.JWT.SecurityUser;
import kg.example.bankingapplication.Web.Security.Service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final CardService cardService;
    private final ClientService clientService;
    private final TransactionService transactionService;
    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }else if (authentication.getPrincipal().equals("authentication")){
            return null;
        }
        return (SecurityUser) authentication.getPrincipal();
    }

    @Override
    public boolean canAccessClient(UUID clientId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        return clientId.equals(id);

    }

    @Override
    public boolean canAccessCard(UUID cardId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        return client
                .getCards()
                .stream()
                .anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(Card card) {
        try {
            Card foundCard = cardService.getByNumberAndDateAndCvv(
                    card.getNumber(),
                    card.getDate(),
                    card.getCvv()
            );//найденая карта
            return canAccessCard(foundCard.getId());
        }catch (ResourceNotFoundException e){
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        UUID id =  user.getId();
        Client client = clientService.getById(id);
        Transaction transaction = transactionService.getById(transactionId);
        return client
                .getCards()
                .contains(transaction.getFrom())
                || client
                .getCards()
                .contains(transaction.getTo());
    }
}

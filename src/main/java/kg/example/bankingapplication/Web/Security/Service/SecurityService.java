package kg.example.bankingapplication.Web.Security.Service;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Web.Security.JWT.SecurityUser;

import java.util.UUID;

public interface SecurityService {
    SecurityUser getUserFromRequest();
    boolean canAccessClient(UUID clientId);
    boolean canAccessCard(UUID cardId);
    boolean canAccessCard (Card card);
    boolean canAccessTransaction(UUID transactionId);
}

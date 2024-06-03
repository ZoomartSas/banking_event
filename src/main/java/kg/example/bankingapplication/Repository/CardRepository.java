package kg.example.bankingapplication.Repository;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Domein.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}

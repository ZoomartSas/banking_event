package kg.example.bankingapplication.Repository;

import kg.example.bankingapplication.Domein.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    boolean existsByNumberAndDate(Long number, LocalDate date);
    Optional<Card> findByNumberAndDateAndCvv(Long number,LocalDate date,short cvv);
}

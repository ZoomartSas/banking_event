package kg.example.bankingapplication.Repository;

import kg.example.bankingapplication.Domein.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsername (String username);

    boolean existsByUsername(String username);
}

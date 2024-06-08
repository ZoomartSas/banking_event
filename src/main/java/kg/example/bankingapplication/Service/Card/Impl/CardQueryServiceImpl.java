package kg.example.bankingapplication.Service.Card.Impl;

import kg.example.bankingapplication.Domein.Exceptions.ResourceNotFoundException;
import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Repository.CardRepository;
import kg.example.bankingapplication.Service.Card.CardQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {
    private final CardRepository cardRepository;
    @Override
    public Card getById(UUID id) {
        return cardRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existByNumberAndDate(Long number, LocalDate date) {
        return cardRepository.existsByNumberAndDate(number,date);
    }
}

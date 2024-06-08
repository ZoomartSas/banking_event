package kg.example.bankingapplication.Web.Mappers;

import kg.example.bankingapplication.Domein.Model.Card;
import kg.example.bankingapplication.Web.DTO.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface CardMapper extends Mappable<Card, CardDto> {
        }

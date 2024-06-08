package kg.example.bankingapplication.Web.Mappers;

import kg.example.bankingapplication.Domein.Model.Client;
import kg.example.bankingapplication.Web.DTO.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}

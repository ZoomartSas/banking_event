package kg.example.bankingapplication.Web.Mappers;

import kg.example.bankingapplication.Domein.Model.Transaction;
import kg.example.bankingapplication.Web.DTO.TransactionDto;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper extends Mappable <Transaction, TransactionDto>{
}

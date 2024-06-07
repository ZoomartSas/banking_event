package kg.example.bankingapplication.Web.Mappers;

import kg.example.bankingapplication.Domein.Model.Account;
import kg.example.bankingapplication.Web.DTO.AccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper  extends Mappable<Account, AccountDto>{
}
